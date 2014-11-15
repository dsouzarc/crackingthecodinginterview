import java.util.LinkedList;

/** 
 * 1.3 Cracking the Coding Interview
 * Removes duplicate characters in string without using
 * additional buffers */

public class OneThree { 

    /** Removes duplicates in N * log(n) */
    public static String removeRepeats(String original) { 
        final LinkedList<Character> values = new LinkedList<Character>();

        for(Character c : original.toCharArray()) { 
            if(!values.contains(c)) { 
                values.add(c);
            }
        }

        final StringBuilder result = new StringBuilder("");

        for(Character c : values) { 
            result.append(c);
        }


        return result.toString();
    }

    public static void main(String[] ryan) { 
        for(String r : ryan) { 
            System.out.println(r + "\t" + removeRepeats(r));
        }
    }
}
