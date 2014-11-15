/** 
 * Written by Ryan D'souza
 * Reverse a C-style string where
 * "abcd" is 5 letters w/ last being a null character */

public class OneTwo { 
    public static String reverse(final String original) { 
        final StringBuilder reverse = new StringBuilder("");
        for(int i = original.length() - 1; i >= 0; i--) { 
            reverse.append(original.charAt(i));
        }

        return reverse.toString();
    }

    public static void main(String[] ryan) { 
        for(String s : ryan) { 
            System.out.println(reverse(s));
        }
    }
}
