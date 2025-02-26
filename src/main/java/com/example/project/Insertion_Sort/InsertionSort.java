package com.example.project.Insertion_Sort;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.Arrays;

public class InsertionSort {
    public static void main(String[] args) {
        int[] arrA = {};
        InsertionSort.selectionSort(arrA);
        System.out.println(Arrays.toString(arrA));
        System.out.println();
        int[] arrB = {};
        InsertionSort.insertionSort(arrB);
        System.out.println(Arrays.toString(arrB));
    }

    // PART A. implementing insertion sort
    public static int[] insertionSort(int[] elements) {
        int loop = 0;
        for (int i = 1; i < elements.length; i++) {  // iterate through list starting at index 1
            // store current element's value
            int temp = elements[i];
            int sectemp = i;
            // set inner loop's index to outer loop's current index
            while (sectemp > 0 && temp < elements[sectemp - 1]) { 
                loop++;
                elements[sectemp] = elements[sectemp - 1];
                sectemp--;
            }
            elements[sectemp] = temp;
        }
        System.out.println(loop);
        return elements;
    }
   
    public static void selectionSort(int[] elements) {
        int loop = 0;
        for (int i = 0; i < elements.length; i++) {
            int min = i;
            for (int j = i + 1; j < elements.length; j++) {
                loop++;
                if (elements[j] < elements[min]) {
                    min = j;
                }
            }
            int temp = elements[i];
            elements[i] = elements[min];
            elements[min] = temp;
        }
        System.out.println(loop);
    }

    // PART B. sorting a 1000-word list
    public static ArrayList<String> insertionSortWordList(ArrayList<String> words) {
        int loop = 0;
        for (int i = 1; i < words.size(); i++) {
            String temp = words.get(i);
            int temp2 = i;
            while (temp2 > 0 && temp.compareTo(words.get(temp2 - 1)) < 0) {
                loop++;
                words.set(temp2, words.get(temp2-1));
                temp2--;
            }
            words.set(temp2, temp);
        }
        System.out.println(loop);
        return words;
    }

    public static void selectionSortWordList(ArrayList<String> words) {
        int loop = 0;
        for (int i = 0; i < words.size() - 1; i++) {
            int minIndex = i;
            for (int j = i + 1; j < words.size(); j++) {
                loop++;
                if (words.get(j).compareTo(words.get(minIndex)) < 0) {
                    minIndex = j;
                }
            }
            String temp = words.get(i);
            words.set(i, words.get(minIndex));
            words.set(minIndex, temp);
        }
        System.out.println(loop);
    }

    public static ArrayList<String> loadWordsInto(ArrayList<String> wordList) {
        try {
            Scanner input = new Scanner(new File("src/main/java/com/example/project/Selection_Sort/words.txt"));
            while (input.hasNext()) {
                String word = input.next();
                wordList.add(word);
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
        return wordList;
    }

   
}