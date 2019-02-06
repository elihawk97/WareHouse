/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Warehouse;
import java.util.Scanner;
import java.util.ArrayList;

/**
 *
 * @author eliha
 */
public class product {
    private String name;
    private double weight;// weight is in ounces ONLY.
    private String color;//use specific colors that will be put into the system
    private double length; //Alldimensions are centimeters
    private double width; //Alldimensions are centimeters
    private double height; //Alldimensions are centimeters
    private double price;//the price of the product.
    private int productID;//The product ID of a specific item
    private static int IDList;//Keeps track of which product ID the system is up to
    private String[] changesList = new String[]{"Name","Type","ID","Height","Length","Width","Color"};
    private String type;//The type/category of item the product is
    Scanner kybd = new Scanner(System.in);
    private String location;
    private static ArrayList<product> allProductList = new ArrayList<>();

    /**
     * Default Constructor
     */
    public product(){
        name = "N/A";
        length = 1;
        width = 1;
        height = 1;
        color = "black";
        weight = 1;
        price = 0;
        productID = IDList;
        IDList = IDList + 1;
        location = "";
        allProductList.add(this);//Adds the new product to the list
    }
    /** 
     *This method initializes all of the 
     * @param title the name of the product
     * @param Aheight the height of the product
     * @param Alength the length of the product
     * @param Awidth the width of the product
     * @param Aweight the weight of the product
     * @param Acolor the color of the product
     */
    public product(String title, double Aheight, double Alength, double Awidth, double Aweight, String Acolor, double Aprice, int column, int row, int shelf, int position){//the parameters of the product
        name = title;
        length = Alength;
        width = Awidth;
        height = Aheight;
        color = Acolor;
        weight = Aweight;
        price = Aprice;
        productID = IDList;
        IDList = IDList + 1;
        location =  column +""+ row + "" + shelf +""+ position ;//Add the place on the shelf
        allProductList.add(this);//Adds the new product to the list        
    }
    // toString will print out the all data about that specific product
    //@param Print - the variable that will be printed
    public String toString(){
        String Print = "ProductID:" + this.getProductID() + "Name:" + getName() +" Length:"+ getLength() +" Height:"+ getHeight() +" Width:"+ getWidth() + " Color: " + getColor();
        return Print;
    }
    //returns a product object
    public product getProduct(){
        
        
        return this;
    }
    /**
     * This "get" method returns the important(defining) details about the
     * product. 
     * In this case "wigs" the essential details are the Style and the Color.
     * @param essentialDetails - the essential details of the product.
     */
    public String getEssentials(){
        String essentialDetails = null;
        essentialDetails = "ProductID:" + this.getProductID() + " Name: " + this.getName() + " Color: " + this.getColor() + "\n";
        return essentialDetails;
    } 
     /**
      * Set specific properties of the product
     * This set of methods are to change a specific detail of the product
     * In the program users will have a choice of which detail they want to change.
     * Depending on which detail of the product they want to change they will 
     * have a choice to choose different options.
     * These options will consist of all of the details about that specific product.
     * Depending on the product there will be a changeProduct method for each detail.
     */

    public void setSpecifiedProperties(){
        System.out.println("Enter the corresponding number of the properites of the product that you want to change:");
        
        //Prints out a list of user commands
        for(int x = 0; x < changesList.length; x++){
            System.out.println(x+"  "+changesList[x]);
        }
        
        Scanner kybd = new Scanner(System.in);
        String userProductChanges = kybd.next();//The integer that stores the user entered fields to change 
        String aChange = ""; //this will break up the user input by command
        String dataChange = null; //the data change that the user wants to a given field
        int dataChangeNum = 0;//the changeing of a data, in a object, that is a number
        
        if(userProductChanges.length() > 0){
        //This forLoop loops through the user-inputed data to check which data he wants to change.
              for(int x = 0; x < changesList.length; x++){
                for(int y = 0; y < userProductChanges.length(); y++){
                    if(changesList[x].length() + y <= userProductChanges.length()){
                        System.out.println("hi");
                        aChange = userProductChanges.substring(y, changesList[x].length());//I think there will be an index out of bounds error here.
                    }
                    if(aChange.compareTo(changesList[x]) == 0){
                        System.out.println("Enter The New " + changesList[x] + " here:");
                        //Checks if the user wants to enter in an integer or a String
                       
                       
                        //This is to dynamically call a method depending on which fields the user wants to change
                        switch (x) { 
                            case 0: 
                                    setName(dataType()); 
                                    System.out.println("");
                                    break; 
                            case 1: 
                                    setType(dataType()); 
                                    break; 
                            case 2: 
                                    setProductID((int) dataType(getProductID())); 
                                    break; 
                            case 3: 
                                    setHeight(dataType(getHeight())); 
                                    break; 
                            case 4:                          
                                    setLength(dataType(getLength())); 
                                    break; 
                            case 5:
                                    setWidth(dataType(getWidth())); 
                                    break; 
                            case 6:
                                    setColor(dataType()); 
                                    break; 
                            default: System.out.println("Invalid Entry");
                                    break;

                    }
                }      
            }
        }
    }
    }  
        
    /**
     * Checks which type of data the variable is
     * The String variable taken in is just so the String variable goes to te right method to sort between Int and String
     */
        
     public String dataType(){
          String dataString = kybd.next();//the user input of what to change the value to  
          return dataString;
        }
    /**
     * Checks which type of data the variable is based on 
     */
        
     public double dataType(double dataInteger){
          dataInteger = kybd.nextInt();//the user input of what to change the value to  
          return dataInteger;   
        }
  /**
   * Change All details of the product.
   * @param title
   * @param Aheight
   * @param Alength
   * @param Awidth
   * @param Aweight
   * @param Acolor 
   */
    public void changeProduct(String title, double Aheight, double Alength, double Awidth, double Aweight, String Acolor){
        setName(title);
        setLength(Alength);
        setWidth(Awidth);
        setHeight(Aheight);
        setColor(Acolor);
        setWeight(Aweight);       
    }


    
    /**
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @return the weight
     */
    public double getWeight() {
        return weight;
    }

    /**
     * @param weight the weight to set
     */
    public void setWeight(double weight) {
        this.weight = weight;
    }

    /**
     * @return the color
     */
    public String getColor() {
        return color;
    }

    /**
     * @param color the color to set
     */
    public void setColor(String color) {
        this.color = color;
    }

    /**
     * @return the length
     */
    public String getDimensions() {
        return "Length: " + length + "\n" + "Width: " + width + "\n" + "Height: " + height;
    }

    /**
     * @param Alength - the new length of the product
     * @param Awidth -  the new width of the product  
     * @param Aheight -  the new height of the product
     */
    public void setDimensions(double aLength, double aWidth, double aHeight) {
        length = aLength;
        width = aWidth;
        height = aHeight;        
    }    

    /**
     * @return the length
     */
    public double getLength() {
        return length;
    }

    /**
     * @param length the length to set
     */
    public void setLength(double length) {
        this.length = length;
    }

    /**
     * @return the width
     */
    public double getWidth() {
        return width;
    }

    /**
     * @param width the width to set
     */
    public void setWidth(double width) {
        this.width = width;
    }

    /**
     * @return the height
     */
    public double getHeight() {
        return height;
    }

    /**
     * @param height the height to set
     */
    public void setHeight(double height) {
        this.height = height;
    }

    /**
     * @return the price
     */
    public double getPrice() {
        return price;
    }

    /**
     * @param price the price to set
     */
    public void setPrice(double price) {
        this.price = price;
    }

    /**
     * @return the productID
     */
    public  double getProductID() {
        return productID;
    }

    /**
     * @param aProductID the productID to set
     */
    public  void setProductID(int aProductID) {
        productID = aProductID;
    }

    /**
     * @return the type
     */
    public String getType() {
        return type;
    }

    /**
     * @param type the type to set
     */
    public void setType(String type) {
        this.type = type;
    }

    /**
     * @return the allProductList
     */
    public static String getAllProductList() {
        String allID = null;
        for(int x = 0; x < allProductList.size(); x++){
            allID = allID + "\n" + allProductList.get(x);
        }
                
        return allID;
    }
    
    /**
     * @return the allProductList
     */
    public static String getAllProductListID() {
        String allID = null;
        for(int x = 0; x < allProductList.size(); x++){
            allID = allID + "\n" + allProductList.get(x).getProductID();
        }
                
        return allID;
    }

    /**
     * @param aAllProductList the allProductList to set
     */
    public static void setAllProductList(ArrayList<product> aAllProductList) {
        allProductList = aAllProductList;
    }



}