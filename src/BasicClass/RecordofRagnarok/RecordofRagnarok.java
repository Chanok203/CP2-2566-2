package BasicClass.RecordofRagnarok;

import java.util.Scanner;

class HumanCharacters {

    String Name;
    String Age;
    boolean Death;
    String Abilities;
    String Personality;
    String Background;

    public HumanCharacters(String Name, String Age, boolean Death, String Abilities, String Personality,
            String Background) {
        this.Name = Name;
        this.Age = Age;
        this.Death = Death;
        this.Abilities = Abilities;
        this.Personality = Personality;
        this.Background = Background;
    }

}

class GodCharacters {

    String Name;
    String Legend;
    String Abilities;
    String Personality;
    String Background;

    public GodCharacters(Scanner sc) {
        String tmp = sc.nextLine();
        int index = tmp.indexOf("(");
        Name = tmp.substring(0, index - 1);
        Legend = tmp.substring(index + 1, tmp.length() - 1);
        Abilities = sc.nextLine();
        Personality = sc.nextLine();
        Background = sc.nextLine();

    }

}

public class RecordofRagnarok {

    private static void battleROR(HumanCharacters h, GodCharacters g, int r) {
        System.out.println("<>---------- Record of Ragnarok ----------<>");
        System.out.println("<< { --------- ROUND ( " + r + " ) --------- } >>");
        System.out.println("<<==== GOD ====>>");
        System.out.println("Name : " + g.Name);
        System.out.println("Legend : [ " + g.Legend + " ]");
        System.out.println("- Abilities: " + g.Abilities);
        System.out.println("- Personality: " + g.Personality);
        System.out.println("- Background: " + g.Background);
        System.out.println("VS");
        System.out.println("<<==== HUMAN ====>>");
        System.out.println("Name : " + h.Name);
        System.out.print("Age : " + h.Age);
        if (h.Death) {
            System.out.println(" at death");
        } else {
            System.out.println("");
        }
        System.out.println("- Abilities: " + h.Abilities);
        System.out.println("- Personality: " + h.Personality);
        System.out.println("- Background: " + h.Background);
        System.out.println("<< { --------- ROUND ( " + r + " ) --------- } >>");
        System.out.println("<>---------- Record of Ragnarok ----------<>");

    }

    public static void main(String[] args) {
        // TODO code application logic here
        Scanner sc = new Scanner(System.in);
        int round = sc.nextInt();
        String t = sc.nextLine();
        HumanCharacters[] human = new HumanCharacters[round];
        GodCharacters[] god = new GodCharacters[round];
        for (int i = 0; i < round; i++) {
            String Age = null;
            boolean Death = false;
            String tmp1[] = sc.nextLine().split("Age: ");
            String Name = tmp1[0].substring(0, tmp1[0].length() - 2);
            if (tmp1[1].indexOf(" at death") > 0) {
                Death = true;
                Age = tmp1[1].substring(0, 2);
            } else if (tmp1[1].indexOf("Unknown") >= 0) {
                Age = "Unknown";
            } else {
                Age = tmp1[1].substring(0, 2);
            }
            String Abilities = sc.nextLine();
            String Personality = sc.nextLine();
            String Background = sc.nextLine();
            human[i] = new HumanCharacters(Name, Age, Death, Abilities, Personality, Background);
        }
        for (int i = 0; i < round; i++) {
            god[i] = new GodCharacters(sc);
        }
        int count = 1;
        for (;;) {
            int h = sc.nextInt();
            int g = sc.nextInt();
            boolean booH = true;
            boolean booG = true;
            if (h < 0 || h >= round) {
                booH = false;
            }
            if (g < 0 || g >= round) {
                booG = false;
            }
            if (booH == true && booG == true) {
                RecordofRagnarok.battleROR(human[h], god[g], count);
                count++;
            } else {
                break;
            }
        }
    }

}
