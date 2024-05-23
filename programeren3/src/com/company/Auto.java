//Erik Wansink Manglano
// Nummer: 1033805
package com.company;

public class Auto implements Runnable{
    private  String naam;
    private Kade kade;
    private Container container;
    Container cargo;
    int max = 6000;
    int min = 1000;

    public Auto (String naam, Kade kade){
        this.naam = naam;
        this.kade = kade;

    }
    public void opakken() throws InterruptedException{
        Container opgepakt = kade.autoPakContainer();
        cargo = opgepakt;
        if (cargo != null){
            System.out.println(naam + " pakt container "+ cargo.get_id() );
            cargo.vastKoppelen();
            //Implementeer dat ze tussen 1 en 6 seconden moeten wachten

            int range = (max - min) + 1;
            int random = (int) (Math.random() * range + min );
            Thread.sleep(random);
        }

    }
    public void afladen () throws InterruptedException{
        if(cargo != null){
            System.out.println("Container " + cargo.get_id() + " is afgeladen door" + naam);
            Container opgepakt = null;
            cargo = null;
        }

    }
    @Override

    public void run(){
        while(kade.isLeeg()) {
            try {

                opakken();
                if(cargo != null){
                    afladen();
                }

            }
            catch (Exception e) {
                e.printStackTrace();
            }

        }
        System.out.println("DONE");
    }
}
