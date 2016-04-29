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

        StdDraw.setCanvasSize(1278, 600);

        File file = new File("C:\\Users\\hcps-faragms\\Google Drive\\MyClasses (15-16)\\Programming Hon\\MP4\\PracticeUSA\\src\\data\\USA.txt");
        Scanner in = new Scanner(file);

        double xmin = in.nextDouble();
        double ymin = in.nextDouble();
        double xmax = in.nextDouble();
        double ymax = in.nextDouble();
        double i = in.nextDouble();

        StdDraw.setXscale(xmin, xmax);
        StdDraw.setYscale(ymin, ymax);
        
        StdDraw.setPenRadius(.0012);
        StdDraw.setPenColor(Color.RED);

        double[] polX;
        double[] polY;

        for (int x = 0; x <= i*2; x++) {
            String State = in.nextLine();
            String Country = in.nextLine();
            while (in.hasNextInt()) {
                int iter = in.nextInt();
                polX = new double[iter];
                polY = new double[iter];
                for (int z = 0; z < iter; z++) {
                    polX[z] = in.nextDouble();
                    polY[z] = in.nextDouble();
                }
                StdDraw.polygon(polX, polY);
                StdDraw.filledPolygon(polX, polY);
            }
        }

    }
}
