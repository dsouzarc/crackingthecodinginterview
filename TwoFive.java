/** 
 * Written by Ryan D'souza
 * Cracking the Coding Interview 2.5
 * Two numbers are stored in a linkedlist in reverse order
 * so that ones digit is at head of list.
 * Add two #s and return sum as linkedlist
 * ex. (7 --> 1 --> 6) + (5 -> 9 -> 2) = 2 -> 1 -> 9 because 617 + 295 = 912 
 *
 * Current Shortcoming: The numbers that are added have to be in the correct digit
 * (1s digit at end, tens second from end, hundreds third from end, etc.
 * This shortcoming will be fixed soon when I add a reverse feature to CustomLinkedList.java
 * and add various improvements 
 * */

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

        int carryOver = 0;
        if(second.size() >= first.size() || firstNode != null) { 
            while(secondNode != null) { 
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
                else { 
                    result.add((Integer) secondNode.value + carryOver);
                    carryOver = 0;
                }

                secondNode = secondNode.previous;
                firstNode = firstNode == null ? null : firstNode.previous;
            }
        }

        if(carryOver > 0) { 
            result.add(carryOver);
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
        System.out.println("SUM\n");
        while(result != null) { 
            System.out.print(result.value);
            result = result.next;
        }
        System.out.println();
    }
}
