/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package csc668assignment1;
import java.util.LinkedList;
import csc668assignment1.UserInterface.*;
//import java.sql.Timestamp;
import csc668assignment1.UserInterface.UserInterface;
//import csc668assignment1.Resources.*;


/**
 * allows the viewing of Invoices and recording of sales as invoices.
 * @author Karl
 */
public class SalesLog {
    //final static String TRANSACTION_FILE_NAME = "transaction.txt"; 
    private LinkedList<Invoice> invoiceList;
    private UserInterface ui;
    SalesLog(){};
    /**
     * shows all invoices in chronological order, earliest to latest, assuming 
     * every Invoice is appended to the LinkedList.
     */
    public void viewAllInvoices(){
        int i,j=0;
        UserInterface ui = new UserInterface();
        Invoice current;
        TransactionItem currentItem;
        TransactionItem[] productList;
        
        if(invoiceList.isEmpty()){
            ui.printToGeneralOut("No Records in Sales Log.");
            return;
        }else{
            for(i=invoiceList.size()-1; i>=0;i--){
                current = invoiceList.get(i);
                productList=current.getProductList();
                currentItem = productList[j];
                ui.printToGeneralOut("name: "+current.getCustomerName()+"\n");
                //printing salesLineItems for the current invoice, 
                //assuming at least one item
                for(j=0; currentItem!=null;j++){
                    ui.printToGeneralOut(null);
                    ui.printToGeneralOut("<"+currentItem.getProductSpec().getDescription()+" "
                        +currentItem.getQuantity()+" @ " 
                        +currentItem.getProductSpec().getUnitPrice()+" "
                        +currentItem.getSubtotal()+">");
                    ui.printToGeneralOut("\n");
                    productList=current.getProductList();
                    currentItem = productList[j];
                    
                }
                //after all items printed, print subtotal and payment.
                ui.printToGeneralOut("-----\n");
                ui.printToGeneralOut("Total: "+current.getTotal());
                ui.printToGeneralOut("\n");
                if(current.getPaymentType().equals("cash")){
                    ui.printToGeneralOut("Cash Tendered: "+current.getAmountTendered());
                    ui.printToGeneralOut("\n");
                    ui.printToGeneralOut("Cash Returned: "+(current.getTotal()-current.getAmountTendered()));
                    ui.printToGeneralOut("\n");
                }else if(current.getPaymentType().equals("check")){
                    ui.printToGeneralOut("Paid by check");
                    ui.printToGeneralOut("\n");
                }else if(current.getPaymentType().equals("credit")){
                    ui.printToGeneralOut("Paid by Credit Card number: "+current.getCardNum());
                    ui.printToGeneralOut("\n");
                }
                
            }
        }
    }
    
    /**
     * Scan through the linked list, looking for and displaying all invoices
     * matching the name given.
     * @param name the name of the person's invoices
     */
    public void viewInvoice(String name){
        int i;
        int j=0;
        Invoice current;
        UserInterface ui = new UserInterface();
        TransactionItem currentItem;
        TransactionItem[] productList;
        
        if(invoiceList.isEmpty()){
            ui.printToGeneralOut("No Records in Sales Log.");
            return;
        }
        
        for(i=invoiceList.size()-1; i>=0;i--){
            current = invoiceList.get(i);
            if((current.getCustomerName().equals(name))){
                //printing salesLineItems for the current invoice
                productList=current.getProductList();
                currentItem = productList[j];
                //printing salesLineItems for the current invoice, 
                //assuming at least one item
                for(j=0; currentItem!=null;j++){
                    ui.printToGeneralOut(null);
                    ui.printToGeneralOut("<"+currentItem.getProductSpec().getDescription()+" "
                        +currentItem.getQuantity()+" @ " 
                        +currentItem.getProductSpec().getUnitPrice()+" "
                        +currentItem.getSubtotal()+">");
                    ui.printToGeneralOut("\n");
                    productList=current.getProductList();
                    currentItem = productList[j];
                    
                }
                //after all items printed, print subtotal and payment.
                ui.printToGeneralOut("-----\n");
                ui.printToGeneralOut("Total: "+current.getTotal());
                ui.printToGeneralOut("\n");
                if(current.getPaymentType().equals("cash")){
                        ui.printToGeneralOut("Cash Tendered: "+current.getAmountTendered());
                        ui.printToGeneralOut("\n");
                        ui.printToGeneralOut("Cash Returned: "+(current.getTotal()-current.getAmountTendered()));
                        ui.printToGeneralOut("\n");
                }else if(current.getPaymentType().equals("check")){
                    ui.printToGeneralOut("Paid by check");
                    ui.printToGeneralOut("\n");
                }else if(current.getPaymentType().equals("credit")){
                    ui.printToGeneralOut("Paid by Credit Card number: "+current.getCardNum());
                    ui.printToGeneralOut("\n");
            }
        }
    }
    }
    
    /**
     * adds the Invoice object to a linked list of past sales.
     * @param t the transaction invoice to be recorded. 
     */
    public void recordInvoice(Invoice t){
        invoiceList.add(t);
    }
    
    
    
}
