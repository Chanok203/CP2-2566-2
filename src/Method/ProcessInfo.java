package Method;

import java.util.Scanner;

public class ProcessInfo {

    static boolean listProcesses(String[] names, int[] ramUses, int totalRAM) {
        int L = names.length;
        int totalUse = 0;
        for (int i = 0; i < L; ++i) {
            String name = names[i];
            int ramUse = ramUses[i];
            totalUse += ramUse;
            if (ramUse < 10) {
                System.out.println(name + " " + ramUse);
            } else {
                System.out.println(name + "* " + ramUse);
            }
        }
        System.out.printf("RAM used = %d out of %d", totalUse, totalRAM);
        System.out.println();
        return totalUse <= totalRAM;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        final int N = sc.nextInt();
        String[] names = new String[N];
        int[] ramUses = new int[N];
        for (int i = 0; i < N; ++i) {
            names[i] = sc.next();
            ramUses[i] = sc.nextInt();
        }
        int totalRAM = sc.nextInt();
        boolean isEnoughRAM = listProcesses(names, ramUses, totalRAM);
        if (isEnoughRAM) {
            System.out.println("Sufficient RAM");
        } else {
            System.out.println("Not enough RAM");
        }
        sc.close();
    }
}
