package com.tarung;

import java.util.Scanner;
import java.io.IOException;
import java.util.Random;
import com.utils.*;

public class Main {
    static String namePlayer;
    static int selectedSpell;
    static int selectedChoice;
    static boolean done = false;
    static boolean keluar = false;
    static boolean hasSelectedSpell = false;

    static void welcome() {
        Scanner scanner = new Scanner(System.in);
        try {
            Console.log("Selamat datang pada game pertarungan dunia lain");
            Console.log("Pertama tama masukkan namamu");
            System.out.print("Masukkan nama mu : ");
            namePlayer = scanner.nextLine();
        } catch (Exception e) {
            scanner.close();
            System.out.println(e);
        }
    }

    public static void main(String[] args) throws IOException {
        Random rand = new Random();
        Monster[] monster = new Monster[3];
        Spell[] spell = new Spell[5];
        Scanner scanner = new Scanner(System.in);

        // Membuat 3 monster
        monster[0] = new Monster("Great Stone", 500);
        monster[1] = new Monster("Dumble Gore", 730);
        monster[2] = new Monster("Hert Mage", 1200);

        // Membuat 5 spell untuk menyerang
        spell[0] = new Spell("Fire Horn", 10);
        spell[1] = new Spell("Lighting Thunder", 15);
        spell[2] = new Spell("Wind Spacing", 32);
        spell[3] = new Spell("Earhquake", 40);
        spell[4] = new Spell("Water Splash", 43);

        welcome();
        Player player = new Player(namePlayer);
        while (keluar != true) {
            System.out.print("\033\143"); // Untuk mengclear console
            player.detail();
            System.out.println("[1] Serang Monster");
            System.out.println("[2] Meditasi");
            System.out.println("[3] Menyerah dalam kehidupan :( ");
            System.out.print("Pilih aksimu : ");
            selectedChoice = scanner.nextInt();
            if (selectedChoice == 1) {
                try {
                    while (done != true) {
                        int iterate = 0;
                        while (monster[iterate].health >= 0 || player.health >= 0) {
                            if (monster[iterate].health <= 0) {
                                iterate++;
                            } else if (player.health == 0) {
                                System.out.println("Kamu telah Mati!, Game berakhir");
                                done = true;
                                keluar = true;
                                break;
                            } else {
                                System.out.print("\033\143"); // Untuk mengclear console
                                int randomSpell = rand.nextInt(5);
                                System.out.println("=============================");
                                Console.log("Monster yang kamu hadapi saat ini adalah " + monster[iterate].name);
                                Console.log("Health Monster : " + monster[iterate].health);
                                System.out.println("=============================");
                                Console.log("Serang dengan spell terkuatmu");
                                Console.log("List Spell yang bisa digunakan : ");

                                for (int i = 1; i <= spell.length; i++) {
                                    System.out.println("[" + i + "] " + spell[i - 1].name);
                                }

                                do {
                                    System.out.print("Pilih spell mu : ");
                                    selectedSpell = scanner.nextInt();
                                    if (player.getPowerStat() >= 10 && selectedSpell - 1 >= 0
                                            && selectedSpell - 1 <= 0) {
                                        player.useSpell(spell[selectedSpell - 1]);
                                        hasSelectedSpell = true;
                                    } else if (player.getPowerStat() >= 30 && selectedSpell - 1 >= 0
                                            && selectedSpell - 1 <= 1) {
                                        player.useSpell(spell[selectedSpell - 1]);
                                        hasSelectedSpell = true;
                                    } else if (player.getPowerStat() >= 40 && selectedSpell - 1 >= 0
                                            && selectedSpell - 1 <= 2) {
                                        player.useSpell(spell[selectedSpell - 1]);
                                        hasSelectedSpell = true;
                                    } else if (player.getPowerStat() >= 50 && selectedSpell - 1 >= 0
                                            && selectedSpell - 1 <= 3) {
                                        player.useSpell(spell[selectedSpell - 1]);
                                        hasSelectedSpell = true;
                                    } else if (player.getPowerStat() >= 100 && selectedSpell - 1 >= 0
                                            && selectedSpell - 1 <= 4) {
                                        player.useSpell(spell[selectedSpell - 1]);
                                        hasSelectedSpell = true;
                                    } else {
                                        Console.log("Kamu tidak cukup kuat untuk menggunakan spell itu");
                                        hasSelectedSpell = false;
                                    }
                                } while (!hasSelectedSpell);
                                player.attackMonster(monster[iterate]);
                                monster[iterate].detail();
                                Wait.time(1000);
                                monster[iterate].useSpell(spell[randomSpell]);
                                monster[iterate].attackPlayer(player);
                                Console.log("Sisa health mu adalah " + player.health);
                                System.out.print("\n\nklik enter untuk melanjutkan...");
                                System.in.read();
                            }
                        }
                        iterate++;
                    }
                } catch (ArrayIndexOutOfBoundsException e) {
                    scanner.close();
                    Console.log("Semua monster telah dikalahkan, Kamu adalah raja dari segala raja");
                    keluar = true;
                }
            } else if (selectedChoice == 2) {
                player.getStronger();
            } else if (selectedChoice == 3) {
                Console.log("Terimakasih sudah bermain game tarung ini");
                Console.log("Jangan patah semangad, tetap jalani hidupmu oke!");
                keluar = true;
            }
        }

    }
}
