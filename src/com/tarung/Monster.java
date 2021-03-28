package com.tarung;

import com.utils.*;

public class Monster extends NPC {
    Spell spell;

    Monster(String name, int health) {
        this.health = health;
        this.name = name;
    }

    public void attackPlayer(Player player) {
        if (player.health <= 0) {
            player.health = 0;
        } else {
            Console.log(this.name + " menyerang!");
            Console.log(this.name + " menyerang menggunakan " + spell.name);
            player.health -= spell.power;
        }
    }

    public void detail() {
        if (this.health <= 0) {
            this.health = 0;
        } else {
            System.out.println("=============================");
            System.out.println("Monster Name : " + this.name);
            System.out.println("Monster Health : " + this.health);
            System.out.println("=============================");

        }
    }

    public void useSpell(Spell spell) {
        this.spell = spell;
    }
}
