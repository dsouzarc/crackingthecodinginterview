/** 
 * Written by Ryan D'souza
 * Cracking the Coding Interview 2.5
 * Two numbers are stored in a linkedlist in reverse order
 * so that ones digit is at head of list.
 * Add two #s and return sum as linkedlist
 * ex. (7 --> 1 --> 6) + (5 -> 9 -> 2) = 2 -> 1 -> 9 because 617 + 295 = 912 */

public class TwoFive { 
    

    //For testing
    public static void main(String[] ryan) { 
        final CustomLinkedList firstNum = new CustomLinkedList();

        final String first = ryan[0];

        for(Character c : first.toCharArray()) { 
            firstNum.add(Character.getNumericValue(c));
        }

        Node head = firstNum.getHead();

        while(head != null) { 
            System.out.println(head.value);
            head = head.next;
        }
    }
}
