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

        //Get to the last node
        while(firstNode != null && firstNode.next != null) { 
            firstNode = firstNode.next;
        }
        while(secondNode != null && secondNode.next != null) { 
            secondNode = secondNode.next;
        }

        if(second.size() >= first.size() || firstNode != null) { 
            int carryOver = 0;

            while(secondNode.previous != null) { 
                if(firstNode != null && firstNode.value != null) { 
                    final Integer sum = (Integer) secondNode.value + (Integer) firstNode.value + carryOver;
                    carryOver = 0;
                    if(sum >= 10) { 
                        result.add(sum - 10);
                        carryOver = 1;
                    }
                    else { 
                        result.add(sum);
                    }
                }

                secondNode = secondNode.previous;
                firstNode = firstNode.previous;
            }
        }


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
        Node result = sum.getHead();

        while(result != null) { 
            System.out.println(result.value);
            result = result.next;
        }
    }
}
