/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package csc668assignment1.Resources;

import csc668assignment1.Transaction_AxelVersion;
import java.rmi.*;
/**
 *
 * @author axelanconaesselmann
 */
public class GuiTransactionsResource extends TransactionsResource {
public GuiTransactionsResource() throws RemoteException{}
    @Override
    public boolean hasNext() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    @Override
    public void printTransaction(Transaction_AxelVersion transaction) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
