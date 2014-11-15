/** Written by Ryan D'souza
 * Cracking the Coding Interview 1.5
 * Write a method to replace all spaces in a string with
 * %20  */

public class OneFive { 
    public static String replaceAll(final String original) { 
        final StringBuilder result = new StringBuilder("");

        for(Character c : original.toCharArray()) { 
            if(c == ' ') { 
                result.append("%20");
            }
            else { 
                result.append(c);
            }
        }

        return result.toString();
    }

    public static void main(String[] ryan) { 
        for(String r : ryan) { 
            System.out.println(r + "\t" + replaceAll(r));
        }
    }
}
