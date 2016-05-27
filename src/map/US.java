/*
Your Name
The Name of the Class
A description of all class variables that explains the variable’s purpose and how it is used
a brief description of any methods in the class.

 */
package map;

import edu.princeton.cs.introcs.StdDraw;
import java.awt.Color;
import java.io.File;
import java.util.HashMap;
import java.util.Scanner;

/**
 *
 * @author hcps-wangq
 */
public class US {
    Coloring[] colors = new Coloring[51];//stores colors

    public US(){

    }//blank constructor
    
    public void drawByCounty(int year) throws Exception{
        File file = new File("src\\data\\USA-county.txt");
        Scanner in = new Scanner(file);
        
        File outLines = new File("src\\data\\USA.txt");
        Scanner outLine = new Scanner(outLines);

        double xmin = in.nextDouble();//gets outer bounds
        double ymin = in.nextDouble();
        double xmax = in.nextDouble();
        double ymax = in.nextDouble();
        int i = in.nextInt();
        
        StdDraw.setCanvasSize(Math.abs((int)((xmax - xmin) * 20 + 20)), (int)((ymax - ymin) * 20 + 20));//sets outer bounds

        StdDraw.setXscale(xmin - ((xmax - xmin)/10), xmax + ((xmax - xmin)/10));//sets the scales
        StdDraw.setYscale(ymin - ((ymax - ymin)/10), ymax + ((ymax - ymin)/10));

        StdDraw.setPenRadius(0);

        in.nextLine();

        Coloring[] colors = new Coloring[51];//colors for everything (each color is one state)
        int counter = 1;//counts which state
        
        double[] polX = new double[10];//creates arrays to hold points
        double[] polY = new double[10];
        
        String name = "";//stores name of county
        String state = "";//name of state
        String lastState = "";//name of previous state
        StdDraw.setPenRadius(0.001);//make pen the right size

        while(in.hasNext()){
            in.nextLine();//gets rid of space
            name = in.nextLine();//gets name of county
            state = in.nextLine();//gets name of state
            
            int numberPoints = in.nextInt();//number of points in the county
            
            if(state.compareTo(lastState) != 0){//if it is a new state
                colors[counter] = new Coloring();//makes to coloring for that state
                File fileState = new File("src\\data\\"+state + year +".txt");//find right file
                Scanner scanState = new Scanner(fileState);
                colors[counter].voteStates(scanState);//calculates the colors for all of the counties
                lastState = state;//makes sure that this state wont run again
                counter++;//moves on to next state
            }
            polX = new double[numberPoints];//makes the arrays the correct length
            polY = new double[numberPoints];
            
            int c = 0;//counts through the array of points
            while (in.hasNextDouble()) {//goes through all of the points
                polX[c] = in.nextDouble();//gets points
                polY[c] = in.nextDouble();
                c++;//next point
            }
            try{
                if(state.compareTo("LA") == 0){//checks if the state is Lousiana (all states called parishes)
                    StdDraw.setPenColor(colors[counter-1].getMapColor(name.replace(" Parish", "")));//gets rid of parish and check
                }
                else{
                    StdDraw.setPenColor(colors[counter-1].getMapColor(name));//tries if not in LA
                }
            }
            catch(Exception e){
                try{
                    StdDraw.setPenColor(colors[counter-1].getMapColor(name.replace(" city", "")));//if above fails, try removing city
                }
                catch(Exception x){
                   StdDraw.setPenColor(0,0,0);//if that doesn't work, make it black
                }  
            }
            StdDraw.filledPolygon(polX, polY);//draw the county
            in.nextLine();//spacing
        }
        drawByStateBlank();//draws outlines of states
    }
    
    public void drawByState(int year) throws Exception{
        
        File file = new File("src\\data\\USA.txt");
        Scanner in = new Scanner(file);

        double xmin = in.nextDouble();//gets bounds
        double ymin = in.nextDouble();
        double xmax = in.nextDouble();
        double ymax = in.nextDouble();
        int i = in.nextInt();
        
        StdDraw.setCanvasSize(Math.abs((int)((xmax - xmin) * 20 + 20)), (int)((ymax - ymin) * 20 + 20));//set bounds

        StdDraw.setXscale(xmin - ((xmax - xmin)/10), xmax + ((xmax - xmin)/10));//sets scales
        StdDraw.setYscale(ymin - ((ymax - ymin)/10), ymax + ((ymax - ymin)/10));

        double[] polX = new double[10];//makes arrays to hold points
        double[] polY = new double[10];
        
        
        StdDraw.setPenRadius(0.002);//sets corretc pen radius
        File vFile = new File("src\\data\\USA" + year + ".txt");//gets correct file to find colors
        Scanner vIn = new Scanner(vFile);//make scanner
        Coloring colors = new Coloring();//makes color holder/calculator
        colors.voteStates(vIn);//calculates colors for each state
                
        for (int x = 0; x <= 208; x++) {
            
            String name = in.nextLine();//gets name of state
            
            in.nextLine();//spacing
            
            while (in.hasNextDouble()) {//gets all of the points
                int iter = in.nextInt();
                polX = new double[iter];//sets arrays to correct length
                polY = new double[iter];
                for (int z = 0; z < iter; z++) { // goes through and get one set of points
                    polX[z] = in.nextDouble();
                    polY[z] = in.nextDouble();
                }
                
                    
                    
                try{   
                    StdDraw.setPenColor(colors.getMapColor(name));//sets pen color
                }
                catch(Exception e){
                    StdDraw.setPenColor(new Color(0,0,0));
                }
                
                    
                
                StdDraw.filledPolygon(polX, polY);//draw inside in color
                StdDraw.setPenColor(0, 0, 0);//set color to black
                StdDraw.polygon(polX, polY);//draws outline
                
                
            }
            //in.nextLine();
            
        }

    }
    public void drawByStateBlank() throws Exception{//draws the outline only, designed to run after an aforementioned function
        
        File file = new File("src\\data\\USA.txt");
        Scanner in = new Scanner(file);

        double[] polX = new double[10];
        double[] polY = new double[10];
        
        StdDraw.setPenRadius(0.003);
                
        for (int x = 0; x <= 208; x++) {
            
            String name = in.nextLine();//gets name
            
            in.nextLine();//spacing
            
            while (in.hasNextDouble()) {//gets all points
                int iter = in.nextInt();//makes the arrays the right length
                polX = new double[iter];
                polY = new double[iter];
                for (int z = 0; z < iter; z++) {
                    polX[z] = in.nextDouble();//gets points
                    polY[z] = in.nextDouble();
                }
              
                StdDraw.setPenColor(new Color(0,0,0));//makes the pen black
                    
                StdDraw.polygon(polX, polY);//draws the outline
                
                
            }
        }
    }
    public void drawOneState(String state, int year)throws Exception{//draws a single states, notice parameter
        
        File file = new File("src\\data\\" + state + ".txt");//makes file to read the shapes
        Scanner in = new Scanner(file);
        int size = 4;//size at which the state is diplayed.  This means each length is 4x normal.


        double xmin = size*in.nextDouble();//sets bounds
        double ymin = size*in.nextDouble();
        double xmax = size*in.nextDouble();
        double ymax = size*in.nextDouble();
        int i = in.nextInt();//spacing
        StdDraw.setCanvasSize(Math.abs((int)((xmax - xmin) * 20 + 20)), (int)((ymax - ymin) * 20 + 20));//size

        StdDraw.setXscale(xmin - ((xmax - xmin)/10), xmax + ((xmax - xmin)/10));//sets scale
        StdDraw.setYscale(ymin - ((ymax - ymin)/10), ymax + ((ymax - ymin)/10));

        
        StdDraw.setPenRadius(0.002);
        File vFile = new File("src\\data\\" + state + year + ".txt");//gets color file
        Scanner vIn = new Scanner(vFile);//makes the scanner
        
        Coloring colors = new Coloring();//save/make colors
        colors.voteStates(vIn);//make colors

        
        for (int x = 0; x <= 208; x++) {
            
            String name = in.nextLine();
            
            in.nextLine();//spacing
            
            while (in.hasNextDouble()) {//gets all points
                int iter = in.nextInt();
                double[] polX = new double[iter];
                double[] polY = new double[iter];
                for (int z = 0; z < iter; z++) {
                    polX[z] = size*in.nextDouble();
                    polY[z] = size*in.nextDouble();
                }
    
                try{   
                    StdDraw.setPenColor(colors.getMapColor(name));//tries to find county colors
                }
                catch(Exception e){
                    StdDraw.setPenColor(new Color(0,0,0));//sets to black
                    
                }
                
                    
                
                StdDraw.filledPolygon(polX, polY);//draw in color
                StdDraw.setPenColor(0, 0, 0);//color == black
                StdDraw.polygon(polX, polY);//outline
                
                
            }
            
        }
       

    }
    
}
