/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Warehouse;

import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author eliha
 */
public class productList {
    
    
    private ArrayList<product> allProductList = new ArrayList<>();
    Scanner kybd = new Scanner(System.in);

     public String toString(){
         String all = null;
         int x = 0; //The iterator
         while( x < allProductList.size()){
             all = all + "\nProductID: " + allProductList.get(x).getProductID();
             x++;
         }
         return all;
    }       
      /**
     * This method returns the ID of all products that have that same name
     * @param productID
     * @return 
     */
    public int[] getProductID(String  productName) {
        ArrayList<product> tempList = getProductWithName(productName);
        int[] IDList = null;
        for(int x = 0; x < tempList.size(); x++){
            IDList[x] = (int)tempList.get(x).getProductID();
        }
        return IDList;   
    }
    /**
     * This method returns the ID of all products that have that same name
     * @param productID
     * @return 
     */
    public  ArrayList<product> getProductDetails(String  productName) {
        ArrayList<product> tempList = getProductWithName(productName);
        return tempList;    
    }

    public  ArrayList<product> getAllProducts() {
        return allProductList; //To change body of generated methods, choose Tools | Templates.
    }
    
    /**
     * This method sorts all of the products by name
     * @param unsortedList 
     */
    
    public void sortAllProducts(){
       product temp;
       String tempName;
       
       int toSwap = 0;//place of the product that will be swapped for the right place
       product swapSpot = null;
       
       product check;//The product that is being compared to the other objects
       String checkName;// The name of the product that is being compared to the other objects
       
       for(int x = 0; x < getAllProducts().size() - 1; x++){
           check = getAllProducts().get(x);
           checkName = check.getName();
           for(int y = x + 1; y < getAllProducts().size(); y++){//"y=x" so that it does loop through alreacy sorted areas
               temp = getAllProducts().get(y);
               tempName = temp.getName();
               if(tempName.compareTo(checkName) < 0){
                   toSwap = y;
                   swapSpot = getAllProducts().get(y);
                   checkName = temp.getName();
               }
           }
           if(toSwap != 0){//Even if the "right" object is in the first spot, it will still run properly, because then will not need to change the variable position
                temp = check;
                getAllProducts().set(x, swapSpot);
                getAllProducts().set(toSwap, temp);
           }
       }
    }
    
    
    /**
     * This method gets all products that have the inputed name
     */
    
    public ArrayList<product> getProductWithName(String name){
        //First this will sort the list so it is in alphabetical order by
        sortAllProducts();
        //List of product to return
        ArrayList<product> returnProducts = new ArrayList<>();
         //The length of the arrayList containing the company divisions
        int productAmount = allProductList.size();
        //highest number being searched for
        int high = allProductList.size() - 1; //The arrayList is really 0-length, so substracting one accounts for the fact the zero countsas the first number and "1" as the second
        //lowest number being searched for
        int low = 0;
        //The actual binary Search
           //The preliminary check
        String key =  name;//returns the divsion name that is at that position in the ArrayList, adding the high and low together and then dividing the result by "2
        //The middle number
        int mid = (high + low)/2;       
        //The middle term
        String middleName = allProductList.get(mid).getName();
        if(middleName.compareTo(key) == 0){//compare the user-entered division with the "key" which represents a value in the ArrayList
            returnProducts.add(allProductList.get(mid));
            return allProductsWithName( returnProducts, mid, name);
        }
        else if (middleName.compareTo(key) > 0){ // First, eaarlier, negative. If the first variable being compared is lower than the other variable (meaining it is in the lower half of the list), then the result of the comparison returns a negative number
            high = mid - 1;
        }
        else if (middleName.compareTo(key) < 0){//If the comparison returns a higher number, means the name is in the upper half of the list, so it changes the lowest value to above the middle which was already checked.
            low = mid + 1;
        }          
        //Checking with the loop
        while( high >= low ){
            mid = (high + low)/2;
            middleName = allProductList.get(mid).getName();
        if(middleName.compareTo(key) == 0){//compare the user-entered division with the "key" which represents a value in the ArrayList
            returnProducts.add(allProductList.get(mid));
            return allProductsWithName( returnProducts, mid, name);
        }
        else if (middleName.compareTo(key) > 0){ // First, eaarlier, negative. If the first variable being compared is lower than the other variable (meaining it is in the lower half of the list), then the result of the comparison returns a negative number
            high = mid - 1;
        }
        else if (middleName.compareTo(key) < 0){//If the comparison returns a higher number, means the name is in the upper half of the list, so it changes the lowest value to above the middle which was already checked.
            low = mid + 1;
        }          
        }
        return returnProducts;
    }
    
    /**
     * This method adds the other products with the user-inputed "name"
     * to the productList of products with a certain name
     * @param returnProducts
     * @param posOfProduct
     */
    
    public ArrayList<product>  allProductsWithName(ArrayList<product> returnProducts, int posOfProduct, String name){
        int productNameChecker = posOfProduct;
        productNameChecker--;
        while((productNameChecker >= 0) && (allProductList.get(productNameChecker).getName().compareTo(name) == 0)){//compares the name of the product below the product that had the right name to the user-inputed name
            returnProducts.add(allProductList.get(productNameChecker));
            productNameChecker--;    
        }
        productNameChecker = posOfProduct;
        productNameChecker++;
        while( (productNameChecker <= allProductList.size() - 1) && (allProductList.get(productNameChecker).getName().compareTo(name) == 0) ){//compares the name of the product below the product that had the right name to the user-inputed name. Subtract 1 from the size because the size is measured not including "0", but the actual list is measured including "0"                    
            returnProducts.add(allProductList.get(productNameChecker));
            productNameChecker++;    
        }   
        return returnProducts;
        
    } 
        
    /**
     * This method gets all products that have the inputed name
     */
    
    public ArrayList<product> getProductWithType(String type){
        //List of product to return
        ArrayList<product> returnProducts = new ArrayList<>();
         //The length of the arrayList containing the company divisions
        int productAmount = allProductList.size();
        //highest number being searched for
        int high = allProductList.size() - 1; //The arrayList is really 0-length, so substracting one accounts for the fact the zero countsas the first number and "1" as the second
        //lowest number being searched for
        int low = 0;
        //The actual binary Search
           //The preliminary check
        String key =  type;//returns the divsion name that is at that position in the ArrayList, adding the high and low together and then dividing the result by "2
        //The middle number
        int mid = (high + low)/2;       
        //The middle term
        String middleType = allProductList.get(mid).getType();
        if(middleType.compareTo(key) == 0){//compare the user-entered division with the "key" which represents a value in the ArrayList
            returnProducts.add(allProductList.get(mid));
            return allProductsWithName( returnProducts, mid, type);
        }
        else if (middleType.compareTo(key) < 0){ // First, eaarlier, negative. If the first variable being compared is lower than the other variable (meaining it is in the lower half of the list), then the result of the comparison returns a negative number
            high = mid - 1;
        }
        else if (middleType.compareTo(key) > 0){//If the comparison returns a higher number, means the name is in the upper half of the list, so it changes the lowest value to above the middle which was already checked.
            low = mid + 1;
        }          
        //Checking with the loop
        while( high >= low ){
            mid = (high + low)/2;
            middleType = allProductList.get(mid).getType();
        if(middleType.compareTo(key) == 0){//compare the user-entered division with the "key" which represents a value in the ArrayList
            returnProducts.add(allProductList.get(mid));
            return allProductsWithName( returnProducts, mid, type);
        }
        else if (middleType.compareTo(key) < 0){ // First, eaarlier, negative. If the first variable being compared is lower than the other variable (meaining it is in the lower half of the list), then the result of the comparison returns a negative number
            high = mid - 1;
        }
        else if (middleType.compareTo(key) > 0){//If the comparison returns a higher number, means the name is in the upper half of the list, so it changes the lowest value to above the middle which was already checked.
            low = mid + 1;
        }          
        }
        return returnProducts;
    }
    
    /**
     * This method adds the other products, in addition to the products added
     * with the binary search, with the user-inputed "name"
     * to the productList of products with a certain name
     * @param returnProducts

    */
    
    public ArrayList<product>  allProductsWithType(ArrayList<product> returnProducts, int posOfProduct, String type){
        int productNameChecker = posOfProduct;
        productNameChecker--;
        while(allProductList.get(posOfProduct).getType().compareTo(type) == 0){//compares the name of the product below the product that had the right name to the user-inputed name
            returnProducts.add(allProductList.get(posOfProduct));
            productNameChecker--;    
        }
        productNameChecker = posOfProduct;
        productNameChecker++;
        while(allProductList.get(posOfProduct).getType().compareTo(type) == 0){//compares the name of the product below the product that had the right name to the user-inputed name
            returnProducts.add(allProductList.get(posOfProduct));
            productNameChecker++;    
        }   
        return returnProducts;
        
    }     
    
    /**
     * Find Product
     * Binary search of ID's
     */
    //<<<<------------------FIX------------------->>>>
    public  product findProduct(int ID){
        //The length of the arrayList containing the company divisions
        int productAmount = allProductList.size();
        //highest number being searched for
        int high = allProductList.size() - 1; //The arrayList is really 0-length, so substracting one accounts for the fact the zero countsas the first number and "1" as the second
        //lowest number being searched for
        int low = 0;
        //The middle term
        int mid = 0;
        //The actual binary Search
           //The preliminary check
        int key = (int) allProductList.get(ID).getProductID();//returns the divsion name that is at that position in the ArrayList, adding the high and low together and then dividing the result by "2"
        mid = (high + low)/2;
        if(mid == key){//compare the user-entered division with the "key" which represents a value in the ArrayList
            return allProductList.get(mid);
        }
        else if (mid > key){ // First, eaarlier, negative. If the first variable being compared is lower than the other variable (meaining it is in the lower half of the list), then the result of the comparison returns a negative number
            high = mid - 1;
        }
        else if (mid < key){//If the comparison returns a higher number, means the name is in the upper half of the list, so it changes the lowest value to above the middle which was already checked.
            low = mid + 1;
        }          
        //Checking with the loop
        while( high >= low ){
            key = (int) allProductList.get(ID).getProductID();//returns the divsion name that is at that position in the ArrayList, adding the high and low together and then dividing the result by "2"
            mid = (high + low)/2;
            if(mid == key){//compare the user-entered division with the "key" which represents a value in the ArrayList
                return allProductList.get(mid);
            }
            else if (mid > key){ // First, eaarlier, negative. If the first variable being compared is lower than the other variable (meaining it is in the lower half of the list), then the result of the comparison returns a negative number
                high = mid - 1;
            }
            else if (mid < key){//If the comparison returns a higher number, means the name is in the upper half of the list, so it changes the lowest value to above the middle which was already checked.
                low = mid + 1;
            }           
        }
        return null;
            
    }
    
    
        /**
     * Change Product
     */
    public void changeProduct(){
        int productID;
        productID = kybd.nextInt();
        
    }

    public void add(product newProduct) {
        allProductList.add(newProduct);
    }
/**
 * Edit----------Edit
 * @param x
 * @return 
 */
    String get(int x) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    

}
