/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package map;

import java.awt.Color;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

/**
 *
 * @author hcps-faragms
 */
public class Vote{
    String fileSet = "C:\\Users\\hcps-wangq\\Documents\\NetBeansProjects\\PurpleAmerica\\src\\data\\";
    int elect1;
    int elect2;
    int elect3;
    
     int[] rVotes = new int[51];
     int[] dVotes = new int[51];
     int[] iVotes = new int[51];
     int[] sum = new int[51];
    
    public static void main(String[] args) throws FileNotFoundException {
        Vote num1 = new Vote();
        num1.getVotes();
        num1.color(21);
    }
    
    public void getVotes() throws FileNotFoundException{
         
       File vFile = new File(fileSet + "USA2000.txt");
        Scanner vIn = new Scanner(vFile);
        
        Votes[] v = new Votes[51];

        vIn.next();
        vIn.next();
        vIn.next();
        
        String[] cans = vIn.next().split(",");
        vIn.nextLine();
        
        String rCan = cans[1];
        String dCan = cans[2];
        String iCan = cans[3];
      
        
        for (int j = 0; j <= 50; j++) {
            String[] votes = vIn.nextLine().split(",");
            String state = votes[0];

            //System.out.println(state);
            rVotes[j] = Integer.parseInt(votes[1]);
            dVotes[j] = Integer.parseInt(votes[2]);
            iVotes[j] = Integer.parseInt(votes[3]);
            sum[j] = (Integer.parseInt(votes[1])+Integer.parseInt(votes[2])+Integer.parseInt(votes[3]));

            
        }
       
     }
     
     public Color color(int x){
        elect1 = rVotes[x];
        elect2 = dVotes[x];
        elect3 = iVotes[x];
        //System.out.println(elect1);
        //System.out.println(Arrays.toString(sum));
        int sum1 = sum[x];
        
        
        Color purple = new Color(((255*elect1) / sum1),((255*elect3)/sum1),((255*elect2)/sum1));
        
      
        return purple;
     }
    
}
