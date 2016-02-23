/*
 * Author: Jie Li
 * Date: 2016/2/10
 * Purpose:1. To read product description from a txt file for ProductCatalog
 */
package csc668assignment1;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

/**
 *
 * @author lenovo
 */
public class ProductReader {
    private BufferedReader in;
    private String line;
    public ProductReader(String filename) throws FileNotFoundException{
        this.in = new BufferedReader(new FileReader(filename));
    }
    public boolean hasMoreProduct() throws IOException{
        //boolean hasmore = false;
        //if((line = in.readLine())!= null){
            //hasmore = true;
            //System.out.println(line);
            //String upc = line.substring(0, 4);
            //String description = line.substring(9, 29);
            //float unitPrice = Float.valueOf(line.substring(34));
            //System.out.println(upc + " " + description + " " + unitPrice);
        //};
        //return hasmore;
        return((this.line=in.readLine())!= null);
    
    }
    public ProductSpec getNextProduct(){
        
        String upc = line.substring(0, 4);
        String description = line.substring(9, 29);
        float unitPrice = Float.valueOf(line.substring(34));
        
        return new ProductSpec(upc, description, unitPrice);
       
    }
    //main method for testing
    public static void main(String[] args) throws FileNotFoundException, IOException{
        ProductReader pr = new ProductReader("products.txt");
        int linenumber = 0;
        while(pr.hasMoreProduct()){
            System.out.println(linenumber++);
        }
    }
}
