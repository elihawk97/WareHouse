/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Warehouse;
import java.util.ArrayList;
import java.util.Scanner;
import static Warehouse.product.getAllProductList;

/**
 *
 * @author Eli Hawk
 * This program is to make a blueprint of a warehouse, in order to track where. 
 * all of the products are. it is a **four** dimensional warehouse blueprint.
 * 1) the first dimension is the amount of columns.
 * 2) the second dimension is the amount of rows. 
 * 3) the third dimension is the amount of shelves high that each row has(up and down). 
 * 4) the fourth dimension is where on the shelf the product is (Left to Right).
 * --------------
 * Each Column/Row/shelf will be labeled.
 *      "1" through whatever length the user puts in.
 * Each Shelf will have a set number of slots on it.
 *      -the slots will be labeled by number also.
 * To tell you where the product is the computer will output the location as follows:
 * Column-x; Row-y; Shelf-z; Spot-A;
 * ----------
 * The objects being stored are "products".
 * Products will/can have:
 *     1)  Name
 *     2)  Dimensions:
 *          Length
 *          Width
 *          Height
 *      3) Color
 *      4) ect...depending on product
 * --------
 * Program Functions:
 *  1) Create "wareHouse" -yes
 *      A)Set up the length of the row/column/shelf -yes
 *      B) Store products
 *  2) Add products to an empty shelf
 *  3) Remove products, which will shorten the ArrayList
 *  4) Remove all inventory
 *  5) Move "products" around
 *  6) Retrieve data on a product
 *  7) Retrieve data of which type of products are listed on a shelf
 *  8) Retrieve data of how many types of a specific product you have
 *  9) Retrieve data on how many products you have
 *  10)Give a full invoice of all products you have, of which ever criteria the user 
 *  11)Give an invoice on all of the products in a specific area (shelf/row/column)
 *  12) Give invoice of how many products of a specific type you have.
 *  13)
 *  14)
 *  15)
 *  16)
 * 
 * 
 */
public class WareHouse{




    /**
     * @param storageFacility - the actual layout of the facility.
     * Also this represents all storage locations in the facility.
     * @param columnCount - the amount of columns in the wareHouse.
     */
    private Column[] storageFacility;
    private int columnCount = 1;  
    private productList allProducts;
    /**
     * This is the default constructor, the default is 1 column
     */
    public WareHouse(){
        storageFacility = new Column[columnCount];
        storageFacility[0] = getColumn(0);//FIX IT!!!!!!!!!!!!!!!!!!!!//what is the point of this???
        allProducts = new productList();
    }
    /**
     * This is he constructor of the how many columns are in the storage facility
     * @param columnAmount - the amount of columns in the facility.
     * 
     * 
     * MUST WORK ON THIS AND FIX IT!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
     * 
     * 
     */
    public WareHouse(int columnAmount){
        columnCount = columnAmount;
        storageFacility = new Column[columnCount];
        allProducts = new productList();
    }
    
    /**
     * The toString method will print out all of the important details about each 
     * product in the wareHouse.
     * In this case(for wigs) the relevant details are "Style" and "color"
     * so it will print those two details out.
     * @param productDetails - A string consisting of all of the important 
     * details of each product(all products in the wareHouse).
    */
    public String toString(){
        String allProductDetails = "";//Blank placeholder for the String
        for(int x = 0; x < getColumnCount(); x++){//x - is just an iterating variable
            allProductDetails = allProductDetails + getStorageFacility()[x];//calls the toString for each column
        }
        return allProductDetails;
    }
    
    /**
     * This method is a test. 
     * This is a quazzy constructor, it uses private instance variables to 
     * initialize the the amount "columnCount" variable to initialize the amount 
     * columns that are in the wareHouse.
     * It autopopulates the rows, so I can test my other methods in the program.
     * This method uses the autopopulate methods in Column, row and shelf classes to 
     * autopopulate the wareHouse
     * @param columnAmount - the amount of columns in the wareHouse.
     * @param rowAmount - the user entered amount of rows in the column.
     * @param shelfAmount - the user entered amount of shelves in each row.
     * This parameter is passed to the row class to determine how many shelves 
     * to create per row.
     * @param productAmount - the user entered amount of products on each shelf.
     * This is passed to the Row class which in turn passes it to the Shelf class
     * so that class knows how many products to add to each shelf.
     * (maybe I will just put the code in to randomize the amount of columns, 
     * Rows and shelves there are. Just a thought :)ext method is just a test method to auto-populate the shelves.
     * @param x - an iterator, to iterate over all of the columns
     *  
     */
    public void autoPopulateWareHouse(int columnAmount, int rowAmount, int shelfAmount, int productAmount){
        setColumnCount(columnAmount);//sets the private instance variable of the number of columns to equal the user inputed amount.
        storageFacility = new Column[columnCount];//initializes the Array to contain the user inputed amount of columns in the warehouse.
     //   product newProduct = new product();
        for(int x = 0; x < columnAmount; x++){
            getStorageFacility()[x] = new Column();//Creates the column objects.
            getStorageFacility()[x].autoPopulateColumn(x,rowAmount, shelfAmount, productAmount);
            for(int y = 0; y < (rowAmount*shelfAmount*productAmount); y++){//"y<" all products in the facilty, this allows it to traverse all products
                allProducts.add(storageFacility[x].getProductInColumn(y));
            }
        }
    }
    


    /**
     * Sorting Algorithm to sort all products in the warehouse
     * 
     */

    
    
    /**
     * This method is the "get" method which returns a column.
     * @param columnNum - the number of which column to be returned.
     * This method is used by the addProduct method in the Shelf class.//I don't think that is true.
     */
    public Column getColumn(int columnNum){
        return storageFacility[columnNum];
    }
    
    
        /**
     *this method allows you to add a "product" to the shelf based on the location
     * @param newProduct - the product you are adding to the shelf.
     * This method creates a wareHouse, Column, Row, and Shelf objects.
     * These objects are just place holders that "point" to the actual objects 
     * that make up the wareHouse. This gives access to a specific shelf in the
     * wareHouse. It accomplishes this task by going down the chain of  objects 
     * in the wareHouse, (warehouse-Column-row-shelf) then at the Shelf level it
     * adds the desired product to the shelf.
     */
     
    public void addProduct(product newProduct, int columnNum, int rowNum, int shelfNum){
        getColumn(columnNum).getRow(rowNum).getShelf(shelfNum).addProduct(newProduct, columnNum, rowNum, shelfNum);//adds the product to the proper shelf
        allProducts.add(newProduct);
    }
    public productList getAllProducts() {
        return allProducts; //To change body of generated methods, choose Tools | Templates.
    }
    public void addProduct(product toBeAdded){
        allProducts.add(toBeAdded);
    }
        /**
     * This method removes a "product" from the shelf based on the location of the product
     * These objects are just place holders that "point" to the actual objects 
     * that make up the wareHouse. This gives access to a specific shelf in the
     * wareHouse.
     */
    
    public void removeProduct( int columnNum, int rowNum, int shelfNum, int productSpot){
       getColumn(columnNum).getRow(rowNum).getShelf(shelfNum).removeProduct(productSpot);//adds the product to the proper shelf
    }
    
     /**   ERROR
     * This method removes a "product" from the shelf based on the ID of the product
     * These objects are just place holders that "point" to the actual objects 
     * that make up the wareHouse. This gives access to a specific shelf in the
     * wareHouse.
     */
    
    public void removeProduct(int IDNum){
       getColumn(IDNum);//adds the product to the proper shelf
    }
    
    /**
     * This gets the product based on location
     */
    public product getProduct(int columnNum, int rowNum, int shelfNum, int shelfSpot){
        
        product returnProduct = getColumn(columnNum).getRow(rowNum).getShelf(shelfNum).getProduct(shelfSpot);//adds the product to the proper shelf
        return returnProduct;
    }
    
    /**
     * This gets the product based on the ID
     */
    public product getProduct(int IDNum){
        
        product returnProduct = allProducts.findProduct(IDNum);//gets the product from the productList object
        return returnProduct;
    }
   
    /**
     * This gets the product based on the ID
     */
    public ArrayList<product> getProduct(String productName){
        
        ArrayList<product> returnProduct = allProducts.getProductWithName(productName);//gets the product from the productList object
        return returnProduct;
    } 

    /**
     * @return the storageFacility
     */
    public Column[] getStorageFacility() {
        return storageFacility;
    }


    /**
     * @return the columnCount
     */
    public int getColumnCount() {
        return columnCount;
    }

    /**
     * @param columnCount the columnCount to set
     */
    public void setColumnCount(int columnCount) {
        this.columnCount = columnCount;
    }
    
    /**
     * 
     * @param args 
     */
    public static void userInput(){
        
        Scanner kybd = new Scanner(System.in);
        

    }
    
    /**
     * Main method
     * This tests most of the methods and I believe is fully operational
     * But the program is not finished yet
    */
    public static void main(String[] args) {
        // TODO code application logic here
        System.out.println(
                  "1: "
                + "2: "
                + "3: "
                + "4: "
                + "5: "
                + "6: "
                + "7: "
                + "8: "
                + "9: "
                + "10: "
                );//This is a simple list of commands that the user can enter to manipulate and query data from the database
        WareHouse Jacquelyn = new WareHouse();
        Jacquelyn.autoPopulateWareHouse(5,6,5,20);
        System.out.println(Jacquelyn.getAllProducts());
        System.out.println("hello");
       System.out.println(Jacquelyn);//prints out essential details of all products in the wareHouse.
        Jacquelyn.addProduct(new product("eli",5,10,15,20,"GREEN", 150, 1,1,1,1),4,3,3);
        
        System.out.println( Jacquelyn.getProduct("eli"));
        Jacquelyn.removeProduct(4,3,2,2);  
        Jacquelyn.setColumnCount(10);
        System.out.println(Jacquelyn.getColumn(4));
        System.out.println(getAllProductList());
        System.out.println("hello------------" + Jacquelyn.getProduct("blank"));
        
        System.out.println("If you want to change a property of a product: \n 1: To change based on the ID \n 2: To change based on location");
        Jacquelyn.getProduct(346).setSpecifiedProperties();
        System.out.println(Jacquelyn.getProduct(346));
        
        
        
    }


}
