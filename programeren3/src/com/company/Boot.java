//Erik Wansink Manglano
// Nummer: 1033805
package com.company;

public class Boot {
    Container [] containers = new Container[100];
    public void add_array_values(int id, Container container ){
        containers[id] = container;
        //System.out.println(containers[id]);
    }
    //functie om het printen van array met containers
    public void print_array(){
        for (int i = 0; i < 100; i++) {

            if(containers[i] instanceof ContainerKoud){
                System.out.println("Koude Container " + containers[i].get_id());
            }

            else if(containers[i] instanceof ContainerWarm){
                System.out.println("Warme Container " + containers[i].get_id());
            }
            else if(containers[i] instanceof Container){
                System.out.println("Container " + containers[i].get_id());
            }

        }

    }
    //functie om te laten zien wanneer de boot leeg is
    public boolean loaded_boat(){
        if(containers[99] == null){

            return false;
        }
        else{
            return true;
        }
    }
    // Geeft de containers mee aan de kraan
    public synchronized Container pakContainer(){
        for (int i = 0; i <= 99; i++) {
            if(containers[i] != null){
                Container merker = containers[i];
                containers[i] = null;
                return merker;
            }
        }
        return null;
    }

}
