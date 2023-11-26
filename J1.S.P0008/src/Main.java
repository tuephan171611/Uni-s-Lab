/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package j1.s.p0008;

import java.util.HashMap;
import java.util.Scanner;
import java.util.StringTokenizer;

/**
 *
 * @author admin
 */
public class Main {

    public static void main(String[] args) {
        //Step 1: Input string value
        String value = inputString("Enter your content: ");
        //Step 2: Count the numbers letters in string value
        HashMap countLetters = countNumbersLetters(value);
        //Step 3: Count the numbers characters in string value
        HashMap countCharacters = countNumbersCharacters(value);
        //Step 4: Display the number of letters and characters
        display(countLetters, countCharacters);
    }

    private static String inputString(String msg) {
        Scanner sc = new Scanner(System.in);
        String value;
        //Loop until user enter correct
        while (true) {
            System.out.println(msg);
            value = sc.nextLine().trim();
            //Check string input is empty
            if (value.isEmpty()) {
                System.out.println("Could not be empty, please input a string");
            } else {
                return value;
            }
        }
    }

    private static HashMap countNumbersLetters(String value) {
        HashMap countLetters = new HashMap<String, Integer>();
        StringTokenizer tokenizer = new StringTokenizer(value);
        String token;
        //Loop until tokenizer have token
        while (tokenizer.hasMoreTokens()) {
            token = tokenizer.nextToken();
            //Check token is not a key in hashmap
            if (!countLetters.containsKey(token)) {
                countLetters.put(token, 1);
            } else {
                countLetters.put(token, ((int) countLetters.get(token)) + 1);
            }
        }
        return countLetters;

    }

    private static HashMap countNumbersCharacters(String value) {
        HashMap countCharacters = new HashMap<String, Integer>();
        char array[] = value.toCharArray();
        //Loop until from first element to last element
        for (int i = 0; i < array.length; i++) {
            if (Character.isSpaceChar(array[i])) {
                continue;
            }
            //Check character is not a key in hashmap
            if (!countCharacters.containsKey(array[i])) {
                countCharacters.put(array[i], 1);
            } else {
                countCharacters.put(array[i], ((int) countCharacters.get(array[i])) + 1);
            }
        }
        return countCharacters;
    }

    private static void display(HashMap countLetters, HashMap countCharacters) {
        System.out.println(countLetters);
        System.out.println(countCharacters);
    }
}
