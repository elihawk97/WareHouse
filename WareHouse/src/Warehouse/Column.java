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
 * @class column - is going to be an Array of rows. 
 * The column is a horizantle array of rows (which are verticle(floor to ceiling)).
 * A Column in the wareHouse system goes from the front of the wareHouse to the back.
 * On a flat plane that represents North-South.
 * An array of Rows is East-West: from the left to the right side of the wareHouse.
 * 
 */
public class Column {
        /**
     * @param rowCount - the amount of rows that are in the column
     * @param rowList - the array of rows that form a column.
     * 
     */
    private int rowCount = 1;
    private Row[] rowList;
    private ArrayList<product> productInColumn;

    
    /**
     * this is the default constructor for the amount of rows in a column
     * The default amount is "1"
     */
    public Column(){
        rowList = new Row[rowCount];
        productInColumn = new ArrayList<>();
    }
    /**
     * This constructor constructs the column to contain the amount of rows that 
     * the user inputed.
     * @param rows - the user inputed amount of rows (how many verticle sets
     * there are) per column.
     */
    public Column(int rows){
        rowCount = rows;
        rowList = new Row[rowCount];//The amount of rows in the column.
        productInColumn = new ArrayList<>();
    }

    /**
     * This method returns the amount of rows that are in a column.
     */
    public int getRowCount(){
        return rowCount;//returns the amount of rows per column.
    }
    /**
     * This method returns the user specified Row, that is in the Column.
     * @param specificRow - the row number that the user wants.
     * This method is used by the addProduct method in the Shelf class.
     */
    public Row getRow(int specificRow){
        return getRowList()[specificRow];
    }
    
    /**
     * This method gives you a String of all of the products in a specific 
     * column.
     * This method calls the "toString" method in the row class.
     * Which returns back all of the important details of a row, then the program 
     * loops over all of the rows. Repeating the above mentioned procedure.
     * @param columnImportantDetails - is a String containing all of the important
     * details of all products in that column.
     */
    public String allProductsColumn(){
        String columnImportantDetails = null;
        for(int x = 0; x < getRowCount(); x++){
            columnImportantDetails = columnImportantDetails + getRowList()[x];
        }
        return columnImportantDetails;
    }
    
    /**
     * This method is a test. 
     * It autopopulates the rows, so I can test my other methods in the program.
     * This method uses the autopopulate methods in the row and shelf class to 
     * autopopulate the column.
     * First the method initializes rowCount to the user inputed amount of rows.
     * This method then initializes the Private instance variable Array 
     * "rowList" to contain the user inputed amount of rows (rowAmount).
     * @param rowAmount - the user entered amount of rows in the column.
     * @param shelfAmount - the user entered amount of shelves in each row.
     * This parameter is passed to the row class to determine how many shelves 
     * to create per row.
     * @param productAmount - the user entered amount of products on each shelf.
     *This is passed to the Row class which in turn passes it to the Shelf class
     * so that class knows how many products to add to each shelf.
     * (maybe I will just put the code in to randomize the amount of columns, 
     * Rows and shelves there are. Just a thought :)
     */
    public void autoPopulateColumn( int columnNum, int rowAmount, int shelfAmount, int productAmount){
        setRowCount(rowAmount);//intializes the rowCount to the user inputed amount of rows per column.
        setRowList(new Row[rowAmount]);//initializes the Array to contain the user inputed amount of rows per oclumn.
        for(int x = 0; x < rowAmount; x++){
            getRowList()[x] = new Row();
            getRowList()[x].autoPopulateRow(columnNum, x, shelfAmount, productAmount);
            for(int y = 0; y < shelfAmount * productAmount; y++){//This for loop adds the products on each shelf on to a central ArrayList for the Column. This for-loop loops through the ArrayLists of products for each row. Products multiplies by the amount of shelves equals the total products in that row
                productInColumn.add(rowList[x].getProductInRow(y));
            }
        }
        
            
    }
    
    /**
     * toString method - returns all essential details about all products in 
     * the column.
     * @param columnProducts  - A string representing all of the essential 
     * details of all products in the column.
     */
    public String toString(){
        String columnProducts = "Next column \n";//breakes up the wareHouse by columns.
        for(int x = 0; x < getRowCount(); x++){
            columnProducts = columnProducts + getRowList()[x];
        }
        return columnProducts;
    }

    /**
     * @param rowCount the rowCount to set
     */
    public void setRowCount(int rowCount) {
        this.rowCount = rowCount;
    }

    /**
     * @return the rowList
     */
    public Row[] getRowList() {
        return rowList;
    }

    /**
     * @param rowList the rowList to set
     */
    public void setRowList(Row[] rowList) {
        this.rowList = rowList;
    }

    /**
     * @return the productInColumn
     */
    public product getProductInColumn(int productNum) {
        return productInColumn.get(productNum);
    }

}
