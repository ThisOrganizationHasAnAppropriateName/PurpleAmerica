/*
 * Political Map Project
 * Name: 
 * Block:
 * 
 * Program Purpose:
 *
 * Algorithm:
 * 
 * Future/possible improvements:
 *
 */
package map;

import edu.princeton.cs.introcs.*;
import java.awt.Color;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.lang.Integer;

/**
 *
 * @author
 */
public class PoliticalMap {

    public static void main(String[] args) throws FileNotFoundException {
        
        String fileSet = "C:\\PA\\PurpleAmerica\\src\\data\\";
        
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
        /*
        for (int x = 0; x <= i*2; x++) {
            System.out.println(x);
            String name = in.nextLine();
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
         
            }
        }
        
        US us = new US(s);
        */
        File vFile = new File("C:\\PA\\PurpleAmerica\\src\\data\\USA2000.txt");
        Scanner vIn = new Scanner(vFile);
        
        Votes[] v = new Votes[50];

        vIn.next();
        vIn.next();
        vIn.next();
        
        String[] cans = vIn.next().split(",");
        
        String rCan = cans[1];
        System.out.println(rCan);
        String dCan = cans[2];
        System.out.println(dCan);
        String iCan = cans[3];
        System.out.println(iCan);
        
        for (int j = 0; j < 50; j++) {
            String[] votes = vIn.nextLine().split(",");
            for(int g = 0; g<4; g++){
                System.out.println(votes[g]);
            }
            String state = votes[0];
            System.out.println(state);
            int rVotes = Integer.parseInt(votes[1]);
            int dVotes = Integer.parseInt(votes[2]);
            int iVotes = Integer.parseInt(votes[3]);
            v[j] = new Votes(state, rVotes, dVotes, iVotes, rCan, dCan, iCan);
        }
    }
}
