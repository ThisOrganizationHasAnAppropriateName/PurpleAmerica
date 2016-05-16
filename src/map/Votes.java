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
public class Votes {
    String state;
    int rVotes;
    int dVotes;
    int iVotes;
    String rCan;
    String dCan;
    String iCan;
    
    public Votes(String s, int r, int d, int i, String rC, String dC, String iC){
        state = s;
        rVotes = r;
        dVotes = d;
        iVotes = i;
        rCan = rC;
        dCan = dC;
        iCan = iC;
    }
    
}
