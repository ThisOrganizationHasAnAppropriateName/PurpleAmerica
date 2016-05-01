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

        File file = new File("C:\\Users\\hcps-wangq\\Documents\\NetBeansProjects\\PurpleAmerica\\src\\data\\USA.txt");
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
        
        State[] s = new State[204];
        
        for (int x = 0; x <= i*2; x++) {
            s[x].setName(in.nextLine()); //returns NullPointerException for some reason
            in.nextLine();
            while (in.hasNextDouble()) {
                int iter = in.nextInt();
                polX = new double[iter];
                polY = new double[iter];
                for (int z = 0; z < iter; z++) {
                    polX[z] = in.nextDouble();
                    polY[z] = in.nextDouble();
                }
                s[x].setX(polX);
                s[x].setY(polY);
                StdDraw.polygon(polX, polY);
         
            }
        }
        
        US us = new US(s);

    }
}
