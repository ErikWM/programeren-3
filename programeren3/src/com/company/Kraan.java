//Erik Wansink Manglano
// Nummer: 1033805
package com.company;

public class Kraan implements Runnable{
    private  String naam;
    private Boot boot;
    private Kade kade;
    @Override
    //De loop van de threads
    public  void run(){
        while(boot.loaded_boat()) {
            try {
                kraanSysteem();
            }
            catch (Exception e) {
                e.printStackTrace();
            }
        }
        kade.autoStop(true);
        System.out.println("Kranen zijn gestopt");
    }
    //Constructor
    public Kraan(String naam, Boot boot, Kade kade){
        this.naam = naam;
        this.boot = boot;
        this.kade = kade;
    }
    //Kraan geeft container mee aan de kade
    public void kraanSysteem() throws InterruptedException{
        Container container = boot.pakContainer();
        System.out.println(naam + " pakt " + container.get_id());
        container.losKoppelen();
        Thread.sleep(1000);
        kade.OntvangContainer(container);
    }

}
