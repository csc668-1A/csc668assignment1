
package csc668assignment1;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

/**
 *
 * @author Jie Li
 * Date: 2/11/2016
 * Purpose: build a transactionReader to read transaciton records from a file.
 */
public class TransactionReader {
    private BufferedReader in;
    private String line;
    private Transaction transaction;
    private String customerName;
    private String[] transItems_String;
    private int totalTransItems;
    private String payment;
    public TransactionReader(String transactionFile) throws FileNotFoundException{
        this.in = new BufferedReader(new FileReader(transactionFile));
    }
    public boolean hasMoreTransactions() throws IOException{
        this.line = this.in.readLine();//Always assume this is the line for Customer Name
        if(this.line != null){
            this.customerName = this.line;
            //System.out.println(this.customerName);
            return true;
        }
        return false;
    }
    /*
     * e.g 
     * this.customerName = "Jie";
     * this.transItems_String = new String[2];
     * transItems_String[0] = "1001 2";
     * transItems_String[1] = "1002 1";
     * this.payment = "CASH/CHECK $10000";
     */
    public Transaction getNextTransaction() throws IOException{
        //reset totalTransItems for this new transaction
        this.totalTransItems = 0;
        this.transItems_String = new String[100];
        //read the first line of item
        this.line = this.in.readLine();
        //System.out.println("nextTrans: " + this.line);
        while(!this.line.startsWith("C")){//reports error here
            this.transItems_String[this.totalTransItems++] = this.line;
            this.line = this.in.readLine();
            //System.out.println("nextTrans: " + this.line);
        }
        //comes to the payment
        this.payment = this.line;
        for(int i = 0; i < this.totalTransItems; i++){
            //System.out.println("transItems_String[]: "+this.transItems_String[i]);
        }
        //System.out.println("Payment: " + this.payment);
        //skip the blank line
        this.in.readLine();
        
        this.transaction =  new Transaction(customerName, transItems_String, totalTransItems, payment);
        return this.transaction;
        
    }

    public static void main(String[] args) throws FileNotFoundException, IOException{
        TransactionReader tr = new TransactionReader("Transactions.txt");
         ProductCatalog.getProductCatelog("products.txt").setProductCatelog();
        while(tr.hasMoreTransactions()){
             Transaction t = tr.getNextTransaction(); 
             //System.out.println("printing tranItems:");
             t.printTransItems();
             Invoice i = new Invoice(t);
             i.print();
        }
       

    }
    
}
