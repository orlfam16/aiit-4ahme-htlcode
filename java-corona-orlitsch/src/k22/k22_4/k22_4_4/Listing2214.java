/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package k22.k22_4.k22_4_4;

import java.io.PipedInputStream;
import java.io.PipedOutputStream;

/**
 *
 * @author USER
 */
public class Listing2214 {
    
     public static void main(String[] args) throws Exception {
        
        
        PipedInputStream inPipe = new PipedInputStream();
        PipedOutputStream outPipe = new PipedOutputStream(inPipe);
        Producer2214 p = new Producer2214(outPipe);
        Consumer2214 c = new Consumer2214(inPipe);
        p.start();
        c.start();
    } 
}
