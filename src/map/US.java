/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package map;

import edu.princeton.cs.introcs.StdDraw;
import java.awt.Color;
import java.io.File;
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
    public void drawByCounty(int year) throws Exception{
        File file = new File("C:\\PA\\PurpleAmerica\\src\\data\\USA-county.txt");
        Scanner in = new Scanner(file);
        
        File outLines = new File("C:\\PA\\PurpleAmerica\\src\\data\\USA.txt");
        Scanner outLine = new Scanner(outLines);

        double xmin = in.nextDouble();
        double ymin = in.nextDouble();
        double xmax = in.nextDouble();
        double ymax = in.nextDouble();
        int i = in.nextInt();
        
        StdDraw.setCanvasSize(Math.abs((int)((xmax - xmin) * 20 + 20)), (int)((ymax - ymin) * 20 + 20));

        StdDraw.setXscale(xmin - ((xmax - xmin)/10), xmax + ((xmax - xmin)/10));
        StdDraw.setYscale(ymin - ((ymax - ymin)/10), ymax + ((ymax - ymin)/10));
        
        //StdDraw.setXscale(xmin, xmax);
        //StdDraw.setYscale(ymin, ymax);
        
        
        StdDraw.setPenRadius(0);

        in.nextLine();

        Coloring[] colors = new Coloring[51];
        int counter = 1;
        
        String[] abbreevs = new String[51];
        double[] polX = new double[10];
        double[] polY = new double[10];
        
        String name = "";
        String state = "";
        String lastState = "";
        StdDraw.setPenRadius(0.001);

        while(in.hasNext()){
            in.nextLine();
            name = in.nextLine();
            //System.out.println(name);
            state = in.nextLine();
            
            int numberPoints = in.nextInt();
            
            if(state.compareTo(lastState) != 0){
                
                colors[counter] = new Coloring();
                File fileState = new File("C:\\PA\\PurpleAmerica\\src\\data\\"+state + year +".txt");
                Scanner scanState = new Scanner(fileState);
                colors[counter].voteStates(scanState);
                lastState = state;
                counter++;    
            }
            polX = new double[numberPoints];
            polY = new double[numberPoints];
            
            int c = 0;
            while (in.hasNextDouble()) {
                polX[c] = in.nextDouble();
                polY[c] = in.nextDouble();
                c++;
            }
            try{
                if(state.compareTo("LA") == 0){
                    StdDraw.setPenColor(colors[counter-1].getMapColor(name.replace(" Parish", "")));
                }
                else{
                    StdDraw.setPenColor(colors[counter-1].getMapColor(name));
                }
            }
            catch(Exception e){
                try{
                    StdDraw.setPenColor(colors[counter-1].getMapColor(name.replace(" city", "")));
                }
                catch(Exception x){
                   StdDraw.setPenColor(0,0,0);
                   System.out.println(name + ", " + state ); 
                }  
            }
            StdDraw.filledPolygon(polX, polY);
            in.nextLine();
        }
        drawByStateBlank();
    }
    
    public void drawByState(int year) throws Exception{
        
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
        
        StdDraw.setPenRadius(0.002);
        File vFile = new File("C:\\PA\\PurpleAmerica\\src\\data\\USA" + year + ".txt");
        Scanner vIn = new Scanner(vFile);
        Coloring colors = new Coloring();
        colors.voteStates(vIn);
                
        for (int x = 0; x <= 208; x++) {
            
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
                
                    
                    
                try{   
                    StdDraw.setPenColor(colors.getMapColor(name));
                }
                catch(Exception e){
                    StdDraw.setPenColor(new Color(0,0,0));
                }
                
                    
                
                StdDraw.filledPolygon(polX, polY);
                StdDraw.setPenColor(0, 0, 0);
                StdDraw.polygon(polX, polY);
                
                
            }
            //in.nextLine();
            
        }

    }
    public void drawByStateBlank() throws Exception{
        
        File file = new File("C:\\PA\\PurpleAmerica\\src\\data\\USA.txt");
        Scanner in = new Scanner(file);

        double xmin = in.nextDouble();
        double ymin = in.nextDouble();
        double xmax = in.nextDouble();
        double ymax = in.nextDouble();
        int i = in.nextInt();

        double[] polX = new double[10];
        double[] polY = new double[10];
        
        StdDraw.setPenRadius(0.003);
                
        for (int x = 0; x <= 208; x++) {
            
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
              
                StdDraw.setPenColor(new Color(0,0,0));
                    
                StdDraw.polygon(polX, polY);
                
                
            }
        }
    }
}
