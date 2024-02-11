package BasicClass.KorKorTor.KorKorTor1;

import java.util.Scanner;

class Party {
    private final String partyName;
    private final int numMember;
    private final String[] firstNames;
    private final String[] lastNames;
    private final int[] regionsNumbers;

    Party(String partyName, int numMember, Scanner sc) {
        this.partyName = partyName;
        this.numMember = numMember;
        firstNames = new String[numMember];
        lastNames = new String[numMember];
        regionsNumbers = new int[numMember];
        for (int i = 0; i < numMember; ++i) {
            firstNames[i] = sc.next();
            lastNames[i] = sc.next();
            regionsNumbers[i] = sc.nextInt();
        }
    }

    void printInfo(int regionsNumber) {
        if (regionsNumber < 0) {
            System.out.println("invalid region number");
            return;
        }

        if (regionsNumber == 0) {
            for (int i = 0; i < this.numMember; ++i) {
                System.out.println(this.firstNames[i] + " " + this.lastNames[i] + " " + this.regionsNumbers[i]);
            }
            return;
        }
        boolean printed = false;
        for (int i = 0; i < this.numMember; ++i) {
            if (this.regionsNumbers[i] == regionsNumber) {
                System.out.println(this.firstNames[i] + " " + this.lastNames[i]);
                printed = true;
            }
        }
        if (!printed) {
            System.out.println("none");
        }
    }
}

public class KorKorTor1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        final int N = sc.nextInt();
        final String[] partyNames = new String[N];
        final int[] numMembers = new int[N];
        for (int i = 0; i < N; ++i) {
            partyNames[i] = sc.next();
            numMembers[i] = sc.nextInt();
        }
        final Party[] parties = new Party[N];
        for (int i = 0; i < N; ++i) {
            parties[i] = new Party(partyNames[i], numMembers[i], sc);
        }
        final int K = sc.nextInt();
        for (int i = 0; i < K; ++i) {
            int partyNumber = sc.nextInt() - 1;
            int regionNumber = sc.nextInt();
            parties[partyNumber].printInfo(regionNumber);
        }
        sc.close();
    }
}
