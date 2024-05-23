//Erik Wansink Manglano
// Nummer: 1033805
package com.company;

public class Main {

    public static void main(String[] args) {
        int max = 3;
        int min = 1;
        //maak boot en kade aan
        Boot boot = new Boot();
        Kade kade = new Kade();
        //maak alle threads aan
        Kraan kraanL = new Kraan("LinkseKraan", boot,kade);
        Thread kraanL_thread = new Thread(kraanL);
        Kraan kraanR = new Kraan("RechtseKraan", boot, kade );
        Thread kraanR_thread = new Thread(kraanR);
        Auto auto1 = new Auto("eersteVrachtwagen", kade);
        Thread auto1_thread = new Thread(auto1);
        Auto auto2 = new Auto("tweedeVrachtwagen", kade);
        Thread auto2_thread = new Thread(auto2);
        Auto auto3 = new Auto("derdeVrachtwagen", kade);
        Thread auto3_thread = new Thread(auto3);
        //maak de containers aan
        for (int i = 0; i < 100; i++) {
            int random = (int) (Math.random() * (max - min + 1) + min);
            if (random == 1) {
                Container container = new ContainerNormaal();
                boot.add_array_values(i, container);
            } else if (random == 2) {
                ContainerWarm containerW = new ContainerWarm();
                boot.add_array_values(i, containerW);
            } else if (random == 3) {
                ContainerKoud containerK = new ContainerKoud();
                boot.add_array_values(i, containerK);
            }
        }
        //print de array van de boot met de containers
        boot.print_array();
        //start de threads
        kraanR_thread.start();
        kraanL_thread.start();
        auto1_thread.start();
        auto2_thread.start();
        auto3_thread.start();

    }
}
