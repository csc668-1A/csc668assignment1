/*
 * Classes implementing the UserInterface are responsible for reading and outputting 
 * Transactions and Products
 */
package csc668assignment1.UserInterface;

import csc668assignment1.Invoice;
import csc668assignment1.Payment;
import csc668assignment1.ProductSpec;
import csc668assignment1.Resources.ProductsResourceInterface;
import csc668assignment1.Resources.TransactionsResource;
import csc668assignment1.Resources.MessageResourceInterface;
import csc668assignment1.Resources.ResourceInterface;
import csc668assignment1.Transaction_AxelVersion;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

/**
 *
 * @author axelanconaesselmann
 */
public class UserInterface extends UnicastRemoteObject implements UI{
    protected TransactionsResource      _transactions;
    protected ProductsResourceInterface _products;
    protected MessageResourceInterface  _messages;
    protected ResourceInterface         _generalOut;
    
    public UserInterface() throws RemoteException{}
    /**
     * Reads the next product and returns a Product instance
     * @return Product
     */
    public ProductSpec readNextProduct() throws RemoteException{
        if (_products == null || !_products.hasNext()) return null;
        else {
            String upc         = _products.getUPC();
            String description = _products.getDescription();
            float  price       = _products.getUnitPrice();
            return new ProductSpec(upc, description, price);
        }
    }
    
    /**
     * Reads the next transaction and returns a Transaction_AxelVersion instance
     * @return 
     */
    public Transaction_AxelVersion readNextTransaction() throws RemoteException{
        if (_transactions == null || !_transactions.hasNext()) return null;
        else {
            String name     = _transactions.getName();
            String upc      = _transactions.getUPC();
            int    quantity = _transactions.getQuantity();
            Payment payment = _transactions.getPayment();
            return new Transaction_AxelVersion(name, upc, quantity, payment);
        }
    }
    
    public void printAlertMessage(String message) throws RemoteException{
        _messages.printAlertMessage(message);
    }
    
    /**
     * Prints a Product instance
     * @param product 
     */
    public void printProduct(ProductSpec product)throws RemoteException {
        _products.printProductSpec(product);
    }
    
    /**
     * Prints a Transaction_AxelVersion Instance
     * @param transaction 
     */
    public void printTransaction(Transaction_AxelVersion transaction)throws RemoteException {
        _transactions.printTransaction(transaction);
    }
    
    public void printString(String message)throws RemoteException {
        _messages.printMessage(message);
    }
    
    public void println(String s)throws RemoteException {
        System.out.println(s);
    }
    
    public void print(String s)throws RemoteException {
        System.out.print(s);
    }
    
    public void printToGeneralOut(String str)throws RemoteException {
        _generalOut.printString(str);
    }
}
