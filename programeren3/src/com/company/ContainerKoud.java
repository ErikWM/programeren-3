//Erik Wansink Manglano
// Nummer: 1033805
package com.company;

public class ContainerKoud extends  Container{
    @Override
    public void losKoppelen(){
        System.out.println("word uit koelelement gehaald");
    }
    public void vastKoppelen(){
        System.out.println(" koel element word toegevoegd");
    }
    public ContainerKoud(){
        super();
        this.get_id();
    }
}
