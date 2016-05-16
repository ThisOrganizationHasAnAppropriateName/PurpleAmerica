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
        
        US testing = new US();
        testing.drawByState(2000);
    }
}
