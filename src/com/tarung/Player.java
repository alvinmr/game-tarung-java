package com.tarung;

import com.utils.*;

import java.io.IOException;
import java.util.Random;

interface Mode {
    public void detail();

    public void attackMonster(Monster opponent);

    public void useSpell(Spell spell);

    public int getPowerStat();

}

public class Player extends NPC implements Mode {
    private Spell spell;
    private int power;

    Player(String name) {
        this.health = 100;
        this.name = name;
        this.power = 10;
    }

    public void detail() {
        if (this.health <= 0) {
            this.health = 0;
        } else {
            System.out.println("=============================");
            Console.log("Player Name : " + this.name);
            Console.log("Player Health : " + this.health);
            Console.log("Player Power : " + this.power);
            System.out.println("=============================");
        }
    }

    public void attackMonster(Monster opponent) {
        Console.log(this.name + " menyerang monster!");
        Console.log(this.name + " menyerang menggunakan " + spell.name);
        opponent.health -= attackTotal();
        if (opponent.health <= 0) {
            opponent.health = 0;
            if (opponent.name == "Hert Mage") {
                System.out.println(opponent.name + " kalah! Kamu telah mengalahkan Boss Monster");
            } else {
                System.out.println(opponent.name + " kalah! Lanjutkan!");
            }
        }
    }

    private int attackTotal() {
        return this.spell.power + this.power;

    }

    public void useSpell(Spell spell) {
        this.spell = spell;
    }

    public void getStronger() throws IOException {
        Random random = new Random();
        int upPower = random.nextInt(100);
        Console.log("Tunggu sebentar sedang meditasi");
        Wait.time(2000);
        if (upPower >= 50) {
            this.power += upPower;
            this.health += upPower / 2;
            Console.log("Berhasil bertambah kuat!");
            this.detail();
            Console.wait("klik enter untuk melanjutkan...");

        } else {
            Console.log("Menambah kuat gagal! Coba lagi");
            Console.wait("klik enter untuk melanjutkan...");
        }
    }

    public int getPowerStat() {
        return this.power;
    }
}
