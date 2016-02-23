/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package csc668assignment1.Resources;

/**
 *
 * @author axelanconaesselmann
 */
public class ConsoleResource implements ResourceInterface {

    @Override
    public void printString(String str) {
        System.out.print(str);
    }

    @Override
    public String getString() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
