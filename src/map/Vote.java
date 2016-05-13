/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package map;

import java.awt.Color;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 *
 * @author hcps-faragms
 */
public class Vote{
    
    int elect1;
    int elect2;
    int elect3;
    
    int avg = elect1+ elect2+elect3;
    
    public static void main(String[] args) throws FileNotFoundException {
        Vote num1 = new Vote();
        num1.getVotes();
    }
    
    public void getVotes() throws FileNotFoundException{
         
       File vFile = new File("C:\\Users\\hcps-faragms\\Google Drive\\MyClasses (15-16)\\Programming Hon\\MP4\\PracticeUSA\\src\\data\\USA2000.txt");
        Scanner vIn = new Scanner(vFile);
        
        Votes[] v = new Votes[50];

        vIn.next();
        vIn.next();
        vIn.next();
        
        String[] cans = vIn.next().split(",");
        vIn.nextLine();
        
        String rCan = cans[1];
        System.out.println(rCan);
        String dCan = cans[2];
        System.out.println(dCan);
        String iCan = cans[3];
        System.out.println(iCan);
        
        for (int j = 0; j <= 50; j++) {
            String[] votes = vIn.nextLine().split(",");
            String state = votes[0];
            System.out.println(votes.length);
            System.out.println(state);
            System.out.println(votes[1]);
            int rVotes = Integer.parseInt(votes[1]);
            int dVotes = Integer.parseInt(votes[2]);
            int iVotes = Integer.parseInt(votes[3]);
            //v[j] = new Votes(state, rVotes, dVotes, iVotes, rCan, dCan, iCan);
        }
       
     }
     
     public void color(){
         Color purple = new Color((elect1/avg),(elect2/avg),(elect3/avg));
     }
    
}
