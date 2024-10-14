package com.wyattfredrickson;
// Import necessary libraries
import java.util.ArrayList;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
/**
 * Since I have only worked with ArrayLists and LinkedLists
 * "ArrayList" is the chosen data structure since we need to traverse over all the buckets.
 * LinkedList is typically used for inserting and removing elements at the top or end range, which we do not do in this application.
 * Extra memory would be needed to store the pointers to the next element in the LinkedList as well. 
 */

 
/**
 * The main class for the program that reads a list of words from a file then sorts them using the bucket sort algorithm
 * "Main" class will hold the main method for starting the application as well as methods for functionality
 */
public class Main {
    ArrayList<Word> wordList = new ArrayList<>(); // Creates an ArrayList of Word objects to store the words from the file


    /**
     * Method to display developer information
     */
    public void displayDeveloperInfo() {
        // Display developer information
        System.out.println("Submitted by Wyatt Fredrickson - fredricw@csp.edu");
        System.out.println("I certify that this is my own work");
    }


    /**
     * Method to load data from a text file
     */
    public void loadDataFromFile(String fileName) {
        // Load the data from the file into the wordList ArrayList
        try (BufferedReader br = new BufferedReader(new FileReader(fileName))) { 
            String line; // Creates a string variable to store the line read from the file
            while ((line = br.readLine()) != null) { // While there are still lines to read do the following
                line = line.trim().toLowerCase(); // Removes any leading or trailing whitespace
                if (!line.isEmpty()) { // If the line is not empty do the following
                    Word word = new Word(line); // Creates a new Word object with the line as the value
                    wordList.add(word); // Adds the word object to the wordList ArrayList
                }
            }
        } catch (IOException e) { // Catches an IOException if one occurs
            System.err.println("An error has occurred while trying to read the file: " + e.getMessage()); // Prints an error message to the console
        }
    }

    
    /**
     * Method to sort the words in the wordList ArrayList using the bucket sort algorithm
     */
    @SuppressWarnings("unchecked")
    public void bucketSort(ArrayList<Word> wordList) {
        ArrayList<Word>[] bucket = (ArrayList<Word>[]) new ArrayList[26 + 1]; // Creates an array with a total size of 27 buckets

        for (int i = 0; i < bucket.length; i++) { // For each bucket in the array do the following
            bucket[i] = new ArrayList<>(); // Creates a new ArrayList for each bucket
        }

        for (int charIndex = 19; charIndex >= 0; charIndex--) {

            for (Word word : wordList) { // For each word in the wordList ArrayList do the following
                String wordValue = word.getValue(); // Gets the value of the word object from method getValue()
    
                char currentChar = (charIndex < wordValue.length()) ? wordValue.toLowerCase().charAt(charIndex) : ' '; // Gets the character at the index of the wordValue
                int bucketIndex = (currentChar >= 'a' && currentChar <= 'z') ? currentChar - 'a' : 26; // Gets the index of the bucket based on the character
    
                bucket[bucketIndex].add(word); // Adds the word to the bucket at the bucketIndex
            }

            wordList.clear(); // Clears the wordList ArrayList
            for (int i = 0; i < bucket.length; i++) {
                wordList.addAll(bucket[i]); // Adds all the elements from the bucket to the wordList ArrayList
                bucket[i].clear(); // Clears the bucket
            }
            System.out.println(); // Prints a blank line
            System.out.println("iterating on index: " + charIndex); // Prints the index of the character
            for (Word word : wordList) { // For each word in the wordList ArrayList do the following
                System.out.println(word.getValue()); // Prints the value of the word object
            }
        }
        System.out.println(); // Prints a blank line
    }


    /**
     * 
     * @param args
     */
    public static void main( String[] args ) {
        Main main = new Main(); // Creates a newe Main object

        main.displayDeveloperInfo(); // Calls the displayDeveloperInfo() method
        main.loadDataFromFile("words.txt"); // Calls the loadDataFromFile() method
        main.bucketSort(main.wordList); // Calls the bucketSort() method
        System.out.println("Done..."); // Prints "Done..." to the console
    }
}