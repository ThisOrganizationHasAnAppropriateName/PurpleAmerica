package map;

import java.util.Scanner;

public class County {
    public County(Scanner scan){
        scan.nextLine();
        scan.nextLine();
        String name = scan.nextLine();
        System.out.println(name);
        
        
        String stateName = scan.next();
        System.out.println(stateName);
        
        
        int numberPoints = scan.nextInt();
        System.out.println(numberPoints);
        double[] xVals = new double[numberPoints];
        double[] yVals = new double[numberPoints];
        for(int i = 0; i<numberPoints; i++){
            xVals[i] = scan.nextDouble();
            yVals[i] = scan.nextDouble();
        }
    }
}
