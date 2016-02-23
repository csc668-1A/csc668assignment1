/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package csc668assignment1.Resources;

import csc668assignment1.payment.CashPayment;
import csc668assignment1.payment.CheckPayment;
import csc668assignment1.payment.CreditPayment;
import csc668assignment1.Payment;
import csc668assignment1.Transaction_AxelVersion;
import java.io.BufferedReader;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;

/**
 *
 * @author axelanconaesselmann
 */
public class FileTransactionsResource extends TransactionsResource {
    protected BufferedReader _fileHandler;
    
    public FileTransactionsResource (String fileName) throws ResourceException {
        Path path = FileSystems.getDefault().getPath(fileName);
        try {
            _fileHandler = Files.newBufferedReader(path, StandardCharsets.UTF_8);
        } catch (IOException ex) {
            ResourceException resouceException = new ResourceException();
            resouceException.setMessage("File '" + path.toAbsolutePath().toString() + "' not found.");
            throw resouceException;
        }
    }
    
    @Override
    public boolean hasNext() {
        _currentUpc      = null;
        _currentQuantity = 0;
        _currentPayment  = null;
        _currentName     = null;
        try {
            String line  = _fileHandler.readLine();
            _currentName = line;
            line         = _fileHandler.readLine();
            _currentUpc  = line.substring(0,4);
            if (line.length() > 9) {
                _currentQuantity = Integer.parseInt(line.substring(9,line.length()));
            } else {
                _currentQuantity = 1;
            }
            line = _fileHandler.readLine();
            if (line != null) {
                _currentPayment = _readCurrentPayment(line);
            } else return false;
            line = _fileHandler.readLine(); // read blank line
            return true;
        } catch (IOException ex) {
            return false;
        } catch (NullPointerException ex) {
            return false;
        }
    }
    
    private Payment _readCurrentPayment(String line) {
        int lineLength = line.length();
        if (line.substring(0,4).equals("CASH")) {
            return new CashPayment(Float.parseFloat(line.substring(6,lineLength)));
        } else if (line.substring(0,5).equals("CHECK")) {
            return new CheckPayment(Float.parseFloat(line.substring(7,lineLength)));
        } else if (line.substring(0,6).equals("CREDIT")) {
            return new CreditPayment(line.substring(7,11));
        } else return null;
    }

    @Override
    public void printTransaction(Transaction_AxelVersion transaction) {
        System.out.printf("%s\n%s     %d\n%s\n\n", 
            transaction.getName(), 
            transaction.getUpc(), 
            transaction.getQuantity(),
            transaction.getPayment().toString()
        );
    }
    
}
