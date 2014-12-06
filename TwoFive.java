/** 
 * Written by Ryan D'souza
 * Cracking the Coding Interview 2.5
 * Two numbers are stored in a linkedlist in reverse order
 * so that ones digit is at head of list.
 * Add two #s and return sum as linkedlist
 * ex. (7 --> 1 --> 6) + (5 -> 9 -> 2) = 2 -> 1 -> 9 because 617 + 295 = 912 */

public class TwoFive { 

    public static CustomLinkedList add(final CustomLinkedList first, final CustomLinkedList second) { 
        final CustomLinkedList result = new CustomLinkedList();

        Node firstNode = first.getHead();
        Node secondNode = second.getHead();

        return result;
    }
        
    //For testing
    public static void main(String[] ryan) { 
        final CustomLinkedList firstNum = new CustomLinkedList();
        final CustomLinkedList secondNum = new CustomLinkedList();

        final String first = ryan[0];
        for(Character c : first.toCharArray()) { 
            firstNum.add(Character.getNumericValue(c));
        }

        final String second = ryan[1];
        for(Character c : second.toCharArray()) { 
            secondNum.add(Character.getNumericValue(c));
        }

        final CustomLinkedList sum = add(firstNum, secondNum);
    }
}
