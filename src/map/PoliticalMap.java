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
import static edu.princeton.cs.introcs.StdDraw.setPenColor;
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
        
        State[] s = new State[10000];//needs to be procedural
        
        for (int x = 0; x <= i*2; x++) {
            //System.out.println(x);
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
                setPenColor(new Color(0,0,0));
                StdDraw.polygon(polX, polY);
                int color = (int)(255*Math.random());
                System.out.println(color);
                setPenColor(new Color(0,(255-color), color));
                StdDraw.filledPolygon(polX, polY);
                setPenColor(new Color(0,0,0));
                StdDraw.polygon(polX, polY);
         
            }
        }
        
        US us = new US(s);

    }
}
