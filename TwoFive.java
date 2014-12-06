/** 
 * Written by Ryan D'souza
 * Cracking the Coding Interview 2.5
 * Two numbers are stored in a linkedlist in reverse order
 * so that ones digit is at head of list.
 * Add two #s and return sum as linkedlist
 * ex. (7 --> 1 --> 6) + (5 -> 9 -> 2) = 2 -> 1 -> 9 because 617 + 295 = 912 */

public class TwoFive { 
    /** Custom node class for implementation */
    public static class Node { 
        public final int value;
        public Node previous;
        public Node next;

        public Node (final int value) { 
            this.value = value;
        }

        public Node(final int value, final Node next) { 
            this(value);
            this.next = next;
        }

        public Node(final int value, final Node next, final Node previous) { 
            this(value, next);
            this.previous = previous;
        }
    }
}
