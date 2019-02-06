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
 * @param Shelf - is an array of products.
 */
public class Shelf {
     
    private ArrayList<product> shelves;//A shelf is an array of products 
  /**
   * This is the default constructor, it constructs a shelf, without adding 
   * any products to it
   */
    public Shelf(){
        shelves = new ArrayList<product>();
    }
    
   /**
   * to initialize the shelf add a product.
   * @param x - the product you are adding to the shelf.
   */
    public Shelf(product x){
        shelves = new ArrayList<product>();
        shelves.add(x); //this will add a product to the shelf    
    }

    /**
     *  this method allows you to remove a "product" from the shelf
     * It removes the product that you are working with
     */
    public void removeProduct(int productSpot){
        shelves.remove(productSpot);//this refers to the product that you are dealing with
    }
    /**
     * This method will list all of the products on a specific shelf;
     * It will list the important details.
     * This method loops over all of the products on the "shelf", and returns 
     * the essential details about each product.
     * In the case of wigs it will list the Color and Style
     * @param productsOnShelf - a list of the important deatails about all of the 
     * products on the shelf.
     * @param current - an iterator product object.
     */
    public String toString(){
        String productsOnShelf = "Next Shelf \n";
        for(product current: shelves){
            productsOnShelf = productsOnShelf + current.getEssentials(); //Calls method in Product class    
        }
        return productsOnShelf;
    }
    
    /**
     * This next method is a test to autopopulate a shelf
     * @param numProductsPerShelf - the user entered number of products the 
     * want to add to each shelf.
     */
    public void autoPopulateShelf(int columnNum, int rowNum, int shelfNum, int productAmount){
        for(int x = 0; x < productAmount; x++){
           product newProduct = new product();
           shelves.add(newProduct);//adds a default product to the shelf, based on the default constructor in the product class.                  
        }
    }
    
    /**
     * This method adds a product to a specific shelf.
     * It is used by the addProduct method in the Product class, that class
     * locates the shelf which the user wants to add a product to, then calls 
     * this class which actually adds the product to the shelf.
     * @paaram newProduct - the product being added to the shelf.
     */
    public void addProduct(product newProduct, int columnNum, int rowNum, int shelfNum){
        shelves.add(newProduct);   // THIS METHOD DOES NOT WORK

    }
    
    public product getProduct(int shelfSpot){
        return shelves.get(shelfSpot);
    }
    
       
}
