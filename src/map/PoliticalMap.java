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

/**
 *
 * @author
 */
public class PoliticalMap {

    public static void main(String[] args) throws FileNotFoundException {

        File file = new File("C:\\Users\\hcps-wangq\\Documents\\NetBeansProjects\\PurpleAmerica\\src\\data\\USA-county.txt");
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
        
        File vFile = new File("C:\\Users\\hcps-wangq\\Documents\\NetBeansProjects\\PurpleAmerica\\src\\data\\USA2000.txt");
        Scanner vIn = new Scanner(file);
        
        Votes[] v = new Votes[50];

        for (int j = 0; j < 4; j++) {
            vIn.next();
        }
        
        String rCan = vIn.next();
        String dCan = vIn.next();
        String iCan = vIn.next();
        
        for (int j = 0; j < 50; j++) {
            String state = vIn.next();
            int rVotes = vIn.nextInt();
            int dVotes = vIn.nextInt();
            int iVotes = vIn.nextInt();
            v[j] = new Votes(state, rVotes, dVotes, iVotes, rCan, dCan, iCan);
        }
    }
}
