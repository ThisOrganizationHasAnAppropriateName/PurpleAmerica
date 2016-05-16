/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package map;

import java.awt.Color;
import java.io.File;
import java.util.HashMap;
import java.util.Scanner;

/**
 *
 * @author hcps-hallocbr1
 */
public class Coloring{
    
    HashMap colors = new HashMap<String, Color>();
    
    
    public Coloring(Scanner scan){
        scan.nextLine();
        while(scan.hasNext()){
            String[] votes = scan.nextLine().split(",");
            String name = votes[0];
                    
            int rVotes = Integer.parseInt(votes[1]);
            int dVotes = Integer.parseInt(votes[2]);
            int iVotes = Integer.parseInt(votes[3]);
            int sum = iVotes+rVotes+dVotes;
            Color temp = new Color((255*rVotes)/sum, (255*iVotes)/sum, (255*dVotes)/sum);
            colors.put(name, temp);
        }
    }
    
    public Color getMapColor(String s){
        return (Color) colors.get(s);
        
    }
}
