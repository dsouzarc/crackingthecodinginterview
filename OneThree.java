/** 
 * 1.3 Cracking the Coding Interview
 * Removes duplicate characters in string without using
 * additional buffers */

public class OneThree { 

    /** Removes duplicates in N * log(N) (worst case). */
    public static String removeRepeats(String original) { 
        original = original.toLowerCase();

        //To hold nonduplicated letters
        final StringBuilder result = new StringBuilder("");

        //Look through string
        for(Character c : original.toCharArray()) { 

            //If we have more than 26 letters, end (only 26 letters in alphabet)
            if(result.length() >= 26) { 
                return result.toString();
            }

            //If character is not in nonduplicated letters 
            boolean isContained = false;
            for(int i = 0; i < result.length() && !isContained; i++) { 
                if(result.charAt(i) == c) { 
                    isContained = true;
                }
            }

            //Add it
            if(!isContained) { 
                result.append(c);
            }
        }

        return result.toString();
    }

    public static void main(String[] ryan) { 
        for(String r : ryan) { 
            System.out.println(r + "\t" + removeRepeats(r));
        }
    }
}
