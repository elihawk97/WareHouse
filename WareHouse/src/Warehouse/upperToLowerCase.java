/**
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 * This program will change lowercase letters to uppercase and visa versa.
 * It accomplishes this by comparing each letter to the a String which contains
 * the alphabet and finds the letter that it is the same as in the string using
 * a binary search in the list.
 */
package Warehouse;

/**
 *
 * @author eliha
 */
public class upperToLowerCase {
    
    /**
     * This method will change all letters from the uppercase to the lowercase
     * @param wrongCase
    * @return String - in the right case
     */
    
    private static String lowerList = "abcdefghijklmnopqrstuvwxyz";//it is static, because it can not change
    private static String upperList = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";//it is static, because it can not change
   
    public String upperToLower(String wrongCase){
        String letter = wrongCase.substring(0, 1);//creates String with the first letter of the String, then it will start the changeing process
        String index = "";//It will be String that will represent the list and compare the given letter to the letter in the "to be sorted" String
        int alphaLength = upperList.length(); // the length of the uppercase letter list
        int iterator = 0; //the value that will be used for iterating
        int compare = 0;//used to keep comparative value of the 2 letters
        int one = 0; //The index place of the letter that is being b
        int listHalf; //The half of the list that the binary search has narrowed the search down to 
        int two = 1;
        String rightCase = ""; // the string that was transformed into the right case
        
        while(iterator < wrongCase.length()){
            index = upperList.substring(alphaLength/2, alphaLength/2+1);
            while(letter.compareTo(index) != 0){
                if(0 == letter.compareTo(index)){
                /**
                 * The index of the letter in both the upper and lowercase lists, are the same.
                 * And each letter is only in the list is only listed once.
                 * So once we find the index of the letter in the uppercase list
                 * we know what the index of the lower case letter is the same.
                 */
                    rightCase = rightCase + lowerList.indexOf(upperList.indexOf(index));
                }
                else{
                    if(letter.compareTo(index) > 0){
                        index = upperList.substring(alphaLength/2); //takes the second half of the alphabet list
                    }
                    else if(letter.compareTo(index) > 0){
                        index = upperList.substring(0,alphaLength/2); //takes the first half of the list
                    }
                }
            }
        }
    return rightCase;
    }
   /**
    * This is the same as the previous program except the reverse
    * @param wrongCase
    * @return String - in the right case
    */
    public String lowerToUpper(String wrongCase){
        String letter = wrongCase.substring(0, 1);//creates String with the first letter of the String, then it will start the changeing process
        String index = "";//It will be String that will represent the list and compare the given letter to the letter in the "to be sorted" String
        int alphaLength = upperList.length(); // the length of the uppercase letter list
        int iterator = 0; //the value that will be used for iterating
        int compare = 0;//used to keep comparative value of the 2 letters
        int one = 0; //The index place of the letter that is being b
        int listHalf; //The half of the list that the binary search has narrowed the search down to 
        int two = 1;
        String rightCase = ""; // the string that was transformed into the right case
        
        while(iterator < wrongCase.length()){
            index = lowerList.substring(alphaLength/2, alphaLength/2+1);
            while(letter.compareTo(index) != 0){
                if(0 == letter.compareTo(index)){
                /**
                 * The index of the letter in both the upper and lowercase lists, are the same.
                 * And each letter is only in the list is only listed once.
                 * So once we find the index of the letter in the uppercase list
                 * we know what the index of the lower case letter is the same.
                 */
                    rightCase = rightCase + upperList.indexOf(lowerList.indexOf(index));
                }
                else{
                    if(letter.compareTo(index) > 0){
                        index = lowerList.substring(alphaLength/2); //takes the second half of the alphabet list
                    }
                    else if(letter.compareTo(index) > 0){
                        index = lowerList.substring(0,alphaLength/2); //takes the first half of the list
                    }
                }
            }
        }
    return rightCase;
    }
    public void main(String[] args) {
        String test = "ASGBFDABFIFIUSBDBFIFBVASBFIUFIUBFHBIUFIUFHIUFIUSBFIHBSIHFSIFIUSF";
        test  = upperToLower(test);
        System.out.println(test);
    }
}