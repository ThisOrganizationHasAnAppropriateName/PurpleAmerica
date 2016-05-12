/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package map;

/**
 *
 * @author hcps-wangq
 */
public class US {
    State[] states;
    String file2;
    
    public US(String f){
        file2 = f;
    }
    
    public State[] getState(){
        return states;
    }
    
    public void setState(){
        
    }
    public void drawByCounty(int year) throws FileNotFoundException{
        
        File file = new File(file2+"\\USA-county.txt");
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
                
                Color purple1 = new Color(12,132,120);
                StdDraw.setPenColor(purple1);
                StdDraw.filledPolygon(polX, polY);
                StdDraw.setPenColor(0,0,0);
                StdDraw.polygon(polX, polY);
         
            }
        }
        
        

    
    }
    
    public void drawByState(int year) throws FileNotFoundException{
        
        File file = new File( file2 + "\\USA.txt");
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
                StdDraw.polygon(polX, polY);
                Color purple1 = new Color(12,132,120);
                StdDraw.setPenColor(purple1);
                StdDraw.filledPolygon(polX, polY);
         
            }
        }
        ;
    }
}
