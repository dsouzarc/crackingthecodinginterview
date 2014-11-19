public class TwoTwo { 
    /** Written by Ryan D'souza
     * Cracking the Coding Interview 2.2 
     * Find the kth to last element of linkedlist */

    /** Uses my custom implementation of a LinkedList */ 
    public static int kthToLastValue(LinkedList original, int k) { 
        return (int) original.element();
    }

    public static void main(String[] ryan) { 
        LinkedList ints = new LinkedList();
        ints.add(2);
        ints.add(3);

        System.out.println(kthToLastValue(ints, 2));
    }
}
