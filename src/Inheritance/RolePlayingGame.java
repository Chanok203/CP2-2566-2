package Inheritance;

import java.util.Scanner;

class GameCharacter {
    String name;
    int attack, defense, level;

    void stat() {
        String line = String.format(
                "%s %d %d %d",
                this.name,
                this.level,
                this.attack,
                this.defense);
        System.out.println(line);
    }

}

class Hero extends GameCharacter {
    Hero(String name) {
        super();
        this.name = name;
        this.attack = 10;
        this.defense = 5;
        this.level = 1;
    }

    void hit(Monster monster) {
        int lv = monster.score / 100;
        this.level += lv;
        this.attack += 3 * lv;
        this.defense += 2 * lv;
    }
}

class Monster extends GameCharacter {
    int score;

    Monster(String name, int level, int score) {
        super();
        this.name = name;
        this.level = level;
        this.score = score;
        this.attack = 2 * level;
        this.defense = 3 * level;
    }
}

public class RolePlayingGame {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int M = sc.nextInt();
        Hero[] heros = new Hero[M];
        for (int i = 0; i < M; ++i) {
            String name = sc.next();
            heros[i] = new Hero(name);
        }
        int N = sc.nextInt();
        Monster[] monsters = new Monster[N];
        boolean[] deads = new boolean[N];
        for (int i = 0; i < N; ++i) {
            String name = Integer.toString(i + 1);
            int lv = sc.nextInt();
            int score = sc.nextInt();
            monsters[i] = new Monster(name, lv, score);
        }
        int K = sc.nextInt();
        for (int i = 0; i < K; ++i) {
            int heroIdx = sc.nextInt() - 1;
            int monsterIdx = sc.nextInt() - 1;
            Hero hero = heros[heroIdx];
            Monster monster = monsters[monsterIdx];
            if (!deads[monsterIdx]) {
                hero.hit(monster);
                deads[monsterIdx] = true;
            }
            // hero.stat();
        }
        sc.close();
        for (int i = 0; i < M; ++i) {
            heros[i].stat();
        }
    }
}

/*
 * 1
 * Blossom
 * 4
 * 3 320
 * 2 190
 * 5 670
 * 2 210
 * 3
 * 1 2
 * 1 1
 * 1 3
 */