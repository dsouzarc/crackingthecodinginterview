public class OneOne { 
    /** Written by Ryan D'souza
    * Cracking the Coding Interview 1.1 
    * Implement an algorithm to determine if a string has all unique characters
    * What if you can not use additional data structures?
    * 
    * RUN INSTRUCTIONS 
    * 1. javac OneOne.java
    * 2. java OneOne Ryan RRyan RyanR RyannR etc. 
    */

    public static boolean hasUniqueCharacters(String word) { 
        final String actual = word.toUpperCase();

        //Each letter of the alphabet
        final int[] letters = new int[26];

        for(Character c : actual.toCharArray()) { 
            final int indexValue = ((int) c) - 65; 
            if(letters[indexValue] != 0) {
                return false;
            }
            else { 
                letters[indexValue] += 1;
            }
        }
        return true;
    }

    public static void main(String[] args) { 
        for(String s : args) { 
            System.out.println(s + "\t" + hasUniqueCharacters(s));
        }
    }
}
