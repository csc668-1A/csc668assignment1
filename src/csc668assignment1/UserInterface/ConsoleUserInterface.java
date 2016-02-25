/*
 * 
 */
package csc668assignment1.UserInterface;

import csc668assignment1.Resources.ConsoleResource;
import csc668assignment1.Resources.ConsoleMessageResource;
import csc668assignment1.Resources.FileProductsResource;
import csc668assignment1.Resources.FileTransactionsResource;
import csc668assignment1.Resources.ResourceException;
import java.io.IOException;
import java.rmi.*;

/**
 *
 * @author axelanconaesselmann
 */
public class ConsoleUserInterface extends UserInterface {
    /**
     * 
     * @param transactionsFileName
     * @param productsFileName 
     */
    public ConsoleUserInterface(String transactionsFileName, String productsFileName) throws RemoteException{
        _init();
        try {
            _transactions = new FileTransactionsResource(transactionsFileName);
            _products     = new FileProductsResource(productsFileName);
        } catch (ResourceException ex) {
            this.printAlertMessage("Could not initialize resources:\n\n" + ex.getMessage());
        }
    }
    public ConsoleUserInterface(String transactionsFileName) throws RemoteException{
        _init();
        try {
            _transactions = new FileTransactionsResource(transactionsFileName);
        } catch (ResourceException ex) {
            this.printAlertMessage("Could not initialize resources:\n\n" + ex.getMessage());
        }
    }
    private void _init() {
        _messages   = new ConsoleMessageResource();
        _generalOut = new ConsoleResource();
    }
}
