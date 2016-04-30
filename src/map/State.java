/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package map;

/**
 *
 * @author hcps-wangq
 */
public class State {
    double[] x;
    double[] y;
    String name;
    
    public State(double[] xx, double[] yy, String n){
        x = xx;
        y = yy;
        name = n;
    }
    
    public double[] getX(){
        return x;
    }
    
    public double[] getY(){
        return y;
    }
    
    public String getName(){
        return name;
    }
    
    public void setX(double[] xx){
        x = xx;
    }
    
    public void setY(double[] yy){
        x = yy;
    }
    
    public void setName(String n){
        name = n;
    }
}
