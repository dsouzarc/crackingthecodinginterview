public class TwoTwo { 
    /** Written by Ryan D'souza
     * Cracking the Coding Interview 2.2 
     * Find the kth to last element of linkedlist */

    /** Uses my custom implementation of a LinkedList
     * Unfortunately, I had to check the solution for this one
     * because my previous method of iterating backwards
     * did not work */
    public static int kthToLastValue(Node customList, int k) { 
        if(customList == null) { 
            return 0;
        }

        int i = kthToLastValue(customList.next, k) + 1;

        if(i == k) { 
            System.out.println(customList.value);
        }

        return i;
    }

    public static void main(String[] ryan) { 
        final CustomLinkedList ints = new CustomLinkedList();

        for(int i = 0; i < 5; i++) { 
            ints.add(i);
        }

        kthToLastValue(ints.getHead(), 2);
    }
}
