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
        
        for(int x = 0; x <= dist; x++){
            System.out.println(in.nextInt());//Currently isn't working
        }
        
       
     }
     
     public void color(){
         Color purple = new Color((elect1/avg),(elect2/avg),(elect3/avg));
     }
    
}
