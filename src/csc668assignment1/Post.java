/*
 * Author: Jie Li
 * Date: 2016/2/10
 * Purpose:1. To deal with transactions, print invoices and store invoices to sale log. 
 */
package csc668assignment1;

import java.io.FileNotFoundException;
import java.io.IOException;

public class Post {
    private TransactionReader transactionReader;
    private Transaction currentTrans;
    private Invoice currentInvoice;
    public Post(String transactionFile) throws FileNotFoundException{
        this.transactionReader = new TransactionReader(transactionFile);     
    }
    public void execute() throws IOException{
        while(transactionReader.hasMoreTransactions()){
            this.currentTrans = transactionReader.getNextTransaction();
            //below is for debugging
            //System.out.println("printing transactoin items");
            //this.currentTrans.printTransItems();
            //System.out.println("");
            //end debugging. 
            //this.currentInvoice = new Invoice(this.currentTrans);
            setInvoice();
            currentInvoice.print();
            System.out.println("");
        }
    }
    public void setInvoice(){
        this.currentInvoice = new Invoice(currentTrans);
    }
    //for testing 
    //Result: Post makes use of TransactionReader to read a list of transactions successfully.
    public static void main(String[] args) throws FileNotFoundException, IOException{
        ProductCatalog.getProductCatelog("products.txt").setProductCatelog();
        Post p = new Post("Transactions.txt");
        p.execute();
        
        
    }
    
    
}
