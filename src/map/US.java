/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package map;

import edu.princeton.cs.introcs.StdDraw;
import java.awt.Color;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 *
 * @author hcps-wangq
 */
public class US {
    
    
    public US(){

    }
    
    
    
    public void setState(){
        
    }
    public void drawByCounty(int year) throws FileNotFoundException{
        
        File file = new File("C:\\PA\\PurpleAmerica\\src\\data\\USA-county.txt");
        Scanner in = new Scanner(file);

        double xmin = in.nextDouble();
        double ymin = in.nextDouble();
        double xmax = in.nextDouble();
        double ymax = in.nextDouble();
        int i = in.nextInt();
        
        StdDraw.setCanvasSize(Math.abs((int)((xmax - xmin) * 20 + 20)), (int)((ymax - ymin) * 20 + 20));

        StdDraw.setXscale(xmin - ((xmax - xmin)/10), xmax + ((xmax - xmin)/10));
        StdDraw.setYscale(ymin - ((ymax - ymin)/10), ymax + ((ymax - ymin)/10));
        
        StdDraw.setPenRadius(0);

        double[] polX;
        double[] polY;
        
        State[] s = new State[10000];
        
        for (int x = 0; x <= i*2; x++) {
            System.out.println(x);
            String name = in.nextLine(); //returns NullPointerException for some reason
            in.nextLine();
            while (in.hasNextDouble()) {
                int iter = in.nextInt();
                polX = new double[iter];
                polY = new double[iter];
                for (int z = 0; z < iter; z++) {
                    polX[z] = in.nextDouble();
                    polY[z] = in.nextDouble();
                }
                s[x] = new State(polX, polY, name);
                StdDraw.polygon(polX, polY);
                Color purple1 = new Color(12,132,120);
                StdDraw.setPenColor(purple1);
                StdDraw.filledPolygon(polX, polY);
         
            }
        }
        

    
    }
    
    public void drawByState(int year) throws FileNotFoundException{
        
        File file = new File("C:\\PA\\PurpleAmerica\\src\\data\\USA.txt");
        Scanner in = new Scanner(file);

        double xmin = in.nextDouble();
        double ymin = in.nextDouble();
        double xmax = in.nextDouble();
        double ymax = in.nextDouble();
        int i = in.nextInt();
        
        StdDraw.setCanvasSize(Math.abs((int)((xmax - xmin) * 20 + 20)), (int)((ymax - ymin) * 20 + 20));

        StdDraw.setXscale(xmin - ((xmax - xmin)/10), xmax + ((xmax - xmin)/10));
        StdDraw.setYscale(ymin - ((ymax - ymin)/10), ymax + ((ymax - ymin)/10));
        
        StdDraw.setPenRadius(0);

        double[] polX = new double[10];
        double[] polY = new double[10];
        
        State[] s = new State[10000];
        
        
        File vFile = new File("C:\\PA\\PurpleAmerica\\src\\data\\USA2000.txt");
        Scanner vIn = new Scanner(vFile);
        
                

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
        String lastName = "";
        for (int x = 0; x <= 208; x++) {
            
            String name = in.nextLine();
            if(x == 0){
                lastName = name;
            }
            in.nextLine();
            
            while (in.hasNextDouble()) {
                int iter = in.nextInt();
                polX = new double[iter];
                polY = new double[iter];
                for (int z = 0; z < iter; z++) {
                    polX[z] = in.nextDouble();
                    polY[z] = in.nextDouble();
                
                }
                //s[x] = new State(polX, polY, name);
                //StdDraw.polygon(polX, polY);
                
                if(name.compareTo(lastName) != 0){
                    lastName = name;
                    //System.out.println(x);
                    String[] votes = vIn.nextLine().split(",");
                    String state = votes[0];
                    
                    int rVotes = Integer.parseInt(votes[1]);
                    int dVotes = Integer.parseInt(votes[2]);
                    int iVotes = Integer.parseInt(votes[3]);
                    int sum = (Integer.parseInt(votes[1])+Integer.parseInt(votes[2])+Integer.parseInt(votes[3]));
                    Color purple = new Color(((255*rVotes) / sum),((255*iVotes)/sum),((255*dVotes)/sum));
                    StdDraw.setPenColor(purple);
                    System.out.println(state);
                    System.out.println(purple);
                }
                
                
                StdDraw.filledPolygon(polX, polY);
            }
            //in.nextLine();
            
        }

    }
}
