/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Warehouse;

import java.util.ArrayList;

/**
 *
 * @author eliha
 * 
 * @param Row - is an array of shelves.
 * @param Row - is a verticle array of all of the shelves in a verticle line.
 *  In other words the amount of shelves there are from floor to ceiling.
 */
public class Row {

    

    /**
     * @param shelfCount - the amount of shelves that are in the row
     * @param shelfList - the array of shelves that form a row.
     * 
     */
    private int shelfCount = 1;
    private Shelf[] shelfList;
    private ArrayList<product> productInRow;
    
    /**
     * this is the default constructor for the amount of shelves in a row
     * The default amount is "1"
     */
    public Row(){
        shelfList = new Shelf[shelfCount];
        productInRow = new ArrayList<>();
    }
    /**
     * This constructor constructs the row to contain the amount of shelves that 
     * the user inputed.
     * @param shelves - the user inputed amount of shelves (how many vertical
     * there are) per row.
     */
    public Row(int shelves){
        shelfCount = shelves;
        shelfList = new Shelf[shelfCount];
        productInRow = new ArrayList<>();
    }
    
    /**
     * @param shelfCount the shelfCount to set
     */
    public void setShelfCount(int shelfCount) {
        this.shelfCount = shelfCount;
    }
    /**
     * @param shelfList the shelfList to set
     */
    public void setShelfList(Shelf[] shelfList) {
        this.shelfList = shelfList;
    }
    /**
     * @return the shelfList
     */
    public Shelf[] getShelfList() {
        return shelfList;
    }
    /**
     * @return the shelfList
     */
    public Shelf getShelfList(int whichShelf) {
        return shelfList[whichShelf];
    }

    /**
     * This method returns the amount of shelves that are in a row.
     */
    public int getShelfCount(){
        return shelfCount;//returns the amount of shelves per row.
    }
    
        /**
     * This method returns the user specified Row, that is in the Column.
     * @param specificShelf - the shelf number that the user wants.
     * This method is used by the addProduct method in the Shelf class.
     */
    public Shelf getShelf(int specificShelf){
        return getShelfList()[specificShelf];
    }
    
    /**
     * This method returns all of the essential details of all products 
     * in the row.
     * the call to "shelfList[x]" (x representing whichever row you are calling)
     * invokes the shelf's toString method which returns the important details 
     * about the product.
     * @param rowImportantDetails - the important details of all of the products
     * in the row.
     */
    public String toString(){
        String rowImportantDetails = "Next Row \n";//breakes up the column by rows.
        for(int x = 0; x < getShelfCount(); x++){
            rowImportantDetails = rowImportantDetails + getShelfList()[x];
        }
        return rowImportantDetails;
    }
    /**
     * This method is to create the user inputed amount of shelves per row.
     * First the method initializes shlfCount to the user inputed amount of 
     * shelves per row.
     * It initializes the array shelfList to contain the user entered amount
     * of shelves.
     * Then it will call a method in the Shelf class to auto-populate the row
     * Shelf by Shelf.
     * @param shelfAmount - the user inputed amount of shelves per row
     * @param productAmount - this is the amount of products per shelf
     */
    public void autoPopulateRow(int columnNum, int rowNum, int shelfAmount, int productAmount){
        setShelfCount(shelfAmount);
        setShelfList(new Shelf[getShelfCount()]);//sets the array of shelves to contain the user inputed number of shelves
        for(int x = 0; x < getShelfCount(); x++){
            getShelfList()[x] = new Shelf();//creates a new shelf
            getShelfList()[x].autoPopulateShelf(columnNum, rowNum, x, productAmount);//Calls the autoPopulate method of the shelf class.
            for(int y = 0; y < productAmount; y++){//This for loop adds the products on each shelf on to a central ArrayList for the Row
                //System.out.println( getShelfList(x));
                setProductInRow(getShelfList(x).getProduct(y));
            }
        }
    }

    /**
     * @return the productInRow
     */
    public product getProductInRow(int x) {
        return productInRow.get(x);
    }
    /**
     * @return the productInRow
     */
    public void setProductInRow(product newProduct) {
        productInRow.add(newProduct);
    }    
}
