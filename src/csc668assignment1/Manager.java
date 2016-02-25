/*
 * Author: Paul Previde
 * Manager class: Offers services for opening and closing a store,
 * and initializing (by appropriate requests to other classes) 
 * the product catalog, sales log, and Post.
 * 
 */
package csc668assignment1;
import csc668assignment1.UserInterface.*;


public class Manager {
    
    private static int idNumber = 1;
    private final int managerId;
    
    public Manager () {
        managerId = idNumber;
        idNumber++;
    }
    
    public void openStore (Store store) {
        store.openStore();
    }
    
    public void closeStore (Store store) {
        store.closeStore();
    }
    
    public void initializePost(Store store) {
        store.initializePost();
    }
    
    public ProductCatalog initializeProductCatalog(String filename) {
        ProductCatalog p = null;
        try {
        p = ProductCatalog.getProductCatelog(filename);
        p.setProductCatelog();
        } catch (Exception e) {
            //UserInterface ui = new UserInterface();
            System.out.print("Product Catalog could not be initialized; exiting Post system");
            System.exit(1);
        }
        return p;
    }
    
    public void initializeSalesLog(Store store) {
        store.initializeSalesLog();
    }
    
    
    
}
