/** Written by Ryan D'souza
 * Cracking the Coding Interview 1.4
 * Write a method to decide if two strings are anagrams 
 * An anagram is a new word made with the same exact letters
 * as the old word */

public class OneFour { 
    public static boolean isAnagram(String word1, String word2) { 
        if(word1 == null || word2 == null) { 
            return false;
        }

        if(word1.length() != word2.length()) { 
            return false;
        }

        word1 = word1.toLowerCase();
        word2 = word2.toLowerCase();

        final int[] word1Counts = new int[26];
        final int[] word2Counts = new int[26];

        for(int i = 0; i < word1.length(); i++) { 
            word1Counts[((int) word1.charAt(i)) - 97]++;
            word2Counts[((int) word2.charAt(i)) - 97]++;
        }

        for(int i = 0; i < word1Counts.length; i++) { 
            if(word1Counts[i] != word2Counts[i]) { 
                return false;
            }
        }

        return true;
    }

    public static void main(String[] ryan) { 
        for(int i = 0; i < ryan.length - 1; i++) { 
            System.out.println(ryan[i] + "\t" + ryan[i + 1] + "\t" + 
                                isAnagram(ryan[i], ryan[i + 1]));
        }
    }
}
