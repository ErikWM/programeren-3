//Erik Wansink Manglano
// Nummer: 1033805
package com.company;

public class Kade {
    private Kraan kraan;
    int arraySize;
    boolean kraangestopt = false;
    int kraanAantal;
    //maakt de array van de kade en geeft de values mee.
    Container [] kade = new Container[5];
    public void add_array_values(int id, Container container ){
        kade[id] = container;
        //System.out.println(containers[id]);
    }
    // Functie kijkt als de kade vol is.
    // Daarna stopt de functie de containers in de array van de kade.
    public  synchronized void OntvangContainer(Container container) throws InterruptedException{
        while (arraySize == 4){
            System.out.println("kade is vol");
            wait();

        }
        for (int i = 0; i < 4; i++) {
            if(container != null){
                Container merker = container;
                kade[i] = merker;
                container = null;
                arraySize++;
                print_kade();
                notifyAll();
                return;
            }
        }

     }
    public  synchronized Container autoPakContainer() throws InterruptedException{
        while(arraySize == 0 && kraangestopt == false) {
            System.out.println("kade is leeg");
            wait();
        }
        Container container = null;
        for (int i = 0; i < 4; i++) {
            if(kade[i] != null){
                container = kade[i];
                kade[i] = null;
                arraySize--;
                print_kade();
                break;
            }
        }
        notifyAll();
        return container;
    }
    public void print_kade(){
        for (int i = 0; i < 5; i++) {
            if(kade[i] instanceof ContainerKoud){
                System.out.println("Koude Container " + kade[i].get_id() + " in kade");
            }

            else if(kade[i] instanceof ContainerWarm){
                System.out.println("Warme Container " + kade[i].get_id()+ " in kade");
            }
            else if(kade[i] instanceof Container){
                System.out.println("Container " + kade[i].get_id()+ " in kade");
            }

        }

    }
    public synchronized boolean lege_kade(){
        //wat gaat er fout
        if(kade[0]== null && kade[1]== null && kade[2]== null && kade[3]== null){
                return false;
        }
        else{
            return true;
        }

    }
    public synchronized boolean autoStop(boolean kraanStopt){
        if(kraanStopt == true){
            kraangestopt = true;
            return true;
        }
        kraangestopt = false;
        return false;

    }
    public synchronized boolean isLeeg() {
        if (kraangestopt == true) {
            if (lege_kade() == false) {
                return false;

            }
        }
        return true;
    }
}

