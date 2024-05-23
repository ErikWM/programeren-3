//Erik Wansink Manglano
// Nummer: 1033805
package com.company;

public class ContainerNormaal extends  Container{
    @Override
    public void losKoppelen(){
        System.out.println("wordt afgeladen");
    }
    public void vastKoppelen(){
        System.out.println(" wordt opgehaald");
    }
    public ContainerNormaal(){
        super();
        this.get_id();
    }
}