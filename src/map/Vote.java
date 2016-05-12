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
public class Vote {
    
    int elect1;
    int elect2;
    int elect3;
    
    int avg = elect1+ elect2+elect3;
    
    public static void main(String[] args) throws FileNotFoundException {
        Vote num1 = new Vote();
        num1.getVotes();
    }
    
    public void getVotes() throws FileNotFoundException{
         
        Scanner in = new Scanner(new File("C:\\Users\\hcps-faragms\\Google Drive\\MyClasses (15-16)\\Programming Hon\\MP4\\PracticeUSA\\src\\data\\AK2012.txt"));
        
        int dist = 0;
        while(in.hasNext()){
           String nextWord = in.next();
           if(nextWord.equalsIgnoreCase("District")){
               dist++;
           }
        }
        
        System.out.println(dist);
        
       
     }
     
     public void color(){
         Color purple = new Color((elect1/avg),(elect2/avg),(elect3/avg));
     }
    
}
