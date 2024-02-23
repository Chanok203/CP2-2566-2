package Inheritance.Pokimon.Pokimon3;

import java.util.Scanner;

class PokiStats {
    int[] hps, attks, defends;

    PokiStats(int[] hps, int[] attks, int[] defends) {
        // this.hps = hps.clone();
        // this.attks = attks.clone();
        // this.defends = defends.clone();

        this.hps = new int[6];
        for (int i = 1; i <= 5; ++i) {
            this.hps[i] = hps[i];
        }

        this.attks = new int[6];
        for (int i = 1; i <= 5; ++i) {
            this.attks[i] = attks[i];
        }

        this.defends = new int[6];
        for (int i = 1; i <= 5; ++i) {
            this.defends[i] = defends[i];
        }
    }
}

class Pokimon {
    PokiStats stats;
    String name;
    int level, energy;

    Pokimon(PokiStats stats, String name, int level) {
        this.stats = stats;
        this.name = name;
        this.level = level;
        this.energy = stats.hps[level];
    }

    int attack() {
        return this.stats.attks[this.level];
    }

    int defend() {
        return this.stats.defends[this.level];
    }
}

class WaterPokimon extends Pokimon {

    WaterPokimon(PokiStats stats, String name, int level) {
        super(stats, name, level);
    }

    int attack(WaterPokimon opponent) {
        return this.attack();
    }

    int attack(FirePokimon opponent) { // x2
        return 2 * this.attack();
    }

    int attack(ElectricPokimon opponent) {
        return this.attack();
    }
}

class FirePokimon extends Pokimon {
    FirePokimon(PokiStats stats, String name, int level) {
        super(stats, name, level);
    }

    int attack(WaterPokimon opponent) {
        return this.attack();
    }

    int attack(FirePokimon opponent) {
        return this.attack();
    }

    int attack(ElectricPokimon opponent) {
        return 2 * this.attack();
    }
}

class ElectricPokimon extends Pokimon {
    ElectricPokimon(PokiStats stats, String name, int level) {
        super(stats, name, level);
    }

    int attack(WaterPokimon opponent) {
        return 2 * this.attack();
    }

    int attack(FirePokimon opponent) {
        return this.attack();
    }

    int attack(ElectricPokimon opponent) {
        return this.attack();
    }
}

public class Pokimon3 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int[] hps = new int[6];
        int[] attks = new int[6];
        int[] defends = new int[6];
        WaterPokimon water = null;
        FirePokimon fire = null;
        ElectricPokimon electric = null;
        // Read PokiStats
        for (int t = 1; t <= 3; ++t) {
            for (int level = 1; level <= 5; ++level)
                hps[level] = scan.nextInt();
            for (int level = 1; level <= 5; ++level)
                attks[level] = scan.nextInt();
            for (int level = 1; level <= 5; ++level)
                defends[level] = scan.nextInt();
            PokiStats stats = new PokiStats(hps, attks, defends);
            // Name, level and object creation
            String name = scan.next();
            int level = scan.nextInt();
            if (t == 1)
                water = new WaterPokimon(stats, name, level);
            else if (t == 2)
                fire = new FirePokimon(stats, name, level);
            else if (t == 3)
                electric = new ElectricPokimon(stats, name, level);
        }

        // Write output
        System.out.println(water.attack(water) + " " +
                water.attack(fire) + " " +
                water.attack(electric));
        System.out.println(fire.attack(water) + " " +
                fire.attack(fire) + " " + fire.attack(electric));
        System.out.println(electric.attack(water) + " "
                + electric.attack(fire) + " "
                + electric.attack(electric));
    }

}
