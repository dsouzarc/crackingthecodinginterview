/** Written by Ryan D'souza
 * Cracking the Coding Interview 2.1
 * Remove duplicates from unsorted LinkedList 
 * Without using temporary buffer */
import java.util.Random;

public class TwoOne { 

    //For generating random numbers
    private static final Random generator = new Random();

    private static class Node { 
        /** Represents a node */
        public int val;
        public Node next;

        public Node (int x) { 
            this.val = x;
            next = null;
        }

        public int val() { 
            return this.val;
        }

        public Node next() { 
            return this.next;
        }
    }

    /** Removes without buffer
     * N * log(n) time */
    public static Node removeDuplicates(Node original) { 

        if(original == null || original.next == null) { 
            return original;
        }

        Node top = original;

        while(top != null) { 
            Node after = top;

            while(after != null &&after.next != null) { 
                if(after.next.val == top.val) { 
                    after = after.next.next;
                }
                else { 
                    after = after.next;
                }
            }
            top = top.next;
        }
        return original;
    }
    
    public static void main(String[] ryan) { 
        final int MAX = 25;
        final int range = (int) MAX / 2;
        
        final Node first = new Node(generator.nextInt(range));
        Node thereAfter = first;
        for(int i = 0; i < MAX; i++) { 
            thereAfter.next = new Node(generator.nextInt(range));
            thereAfter = thereAfter.next;
        }

        System.out.println("OLD VALUES:\t");
        thereAfter = first;
        while(thereAfter.next != null) { 
            System.out.println(thereAfter.val);
            thereAfter = thereAfter.next;
        }

        System.out.println("\nNEW VALUES:\t");
        removeDuplicates(first);
        thereAfter = first;
        while(thereAfter.next != null) { 
            System.out.println(thereAfter.val);
            thereAfter = thereAfter.next;
        }
    }
}
