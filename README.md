Project Overview
This project implements a Bucket Sort Algorithm to sort a list of words from a file. 
The words are read into memory using an ArrayList and sorted by their characters using bucket sort, a technique that distributes elements into different buckets before sorting.


Word Class- The Word class represents an individual word. Each Word object stores a string value.
methods:
getValue(): Returns the string value of the word.

Main Class- The Main class reads the words from a text file, stores them in an ArrayList, and then sorts them using the bucket sort algorithm.
Methods:
displayDeveloperInfo(): Displays the developer's information.
loadDataFromFile(String fileName): Reads words from the specified file (Words.txt) and stores them in the wordList array.
bucketSort(ArrayList<Word> wordList): Sorts the words using the bucket sort algorithm, processing characters from right to left for up to 20 characters.

Words.txt- This file contains the list of words to be sorted. 
The program reads each word from the file and adds it to the wordList.