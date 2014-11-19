/** 
 * Written by Ryan D'souza
 * Represents a Custom LinkedList for me
 * to do problems requiring LinkedLists on */

public class CustomLinkedList { 
    private Node head;
    private int size;

    public CustomLinkedList() { 
        this.head = new Node(null);
        size = 0;
    }

    public void add(final Object value) { 
        final Node nodeVal = new Node(value);
        
        //Node to get to last node
        Node toEnd = this.head;

        while(toEnd.next != null) { 
            toEnd = toEnd.next;
        }

        //Add newest node to end of list
        toEnd.next = nodeVal;
        size++;
    }

    /** More methods will be implemented when the time comes */

    public int size() { 
        return this.size;
    }
}
