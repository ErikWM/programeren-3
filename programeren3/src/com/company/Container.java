//Erik Wansink Manglano
// Nummer: 1033805
package com.company;
public abstract class Container {
    public abstract void vastKoppelen();
    public abstract void losKoppelen();
    int id;
    static int _id;
    public Container(){
        _id++;
        id = _id;
        //System.out.println(id);
    }
    public int get_id(){
        return id;
    }

}
