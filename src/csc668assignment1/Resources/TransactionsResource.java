/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package csc668assignment1.Resources;

import csc668assignment1.Payment;
import csc668assignment1.Transaction_AxelVersion;
import java.io.IOException;
import java.rmi.server.UnicastRemoteObject;
import java.rmi.*;
/**
 *
 * @author axelanconaesselmann
 */
public abstract class TransactionsResource extends UnicastRemoteObject implements TransRMI {

    abstract public boolean hasNext();
    abstract public void printTransaction(Transaction_AxelVersion transaction);
    
    protected String  _currentUpc;
    protected int     _currentQuantity;
    protected Payment _currentPayment;
    protected String  _currentName;
    public TransactionsResource() throws RemoteException{}
    public String getUPC() {
        return _currentUpc;
    }
    public int getQuantity() {
        return _currentQuantity;
    }
    public Payment getPayment() {
        return _currentPayment;
    }
    public String getName() {
        return _currentName;
    }
}
