package com.wyattfredrickson;

/**
 * The Word class is used to create Word objects that store the value of the element of the ArrayList
 */
public class Word {
    // Instance variables 
    private String value; // The value of the element of the ArrayList
    

    /**
     * Constructor for the Element class
     * @param value the value of the element
     */
    public Word(String value) {
        this.value = value; 
    }


    /**
     * Getter method to get the value of the element
     * @return the value of the element
     */
    public String getValue() {
        return value;
    }
}