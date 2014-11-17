/** 
 * Written by Ryan D'souza
 * Represents a single node */

public class Node { 
    public Object value;

    //For single linkedlist
    public Node next;

    //For doubley linkedlist
    public Node previous;

    public Node() { 
    }

    public Node (Object value) { 
        this.value = value;
    }
}
