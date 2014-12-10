/** 
 * Written by Ryan D'souza
 * Represents a Custom LinkedList for me
 * to do problems requiring LinkedLists on */

public class CustomLinkedList { 
    private final Node head;
    private Node lastElement;
    private int size;

    /** Default constructor */
    public CustomLinkedList() { 
        this.head = new Node(null);
        size = 0;
    }

    /** Constructor from existing node */
    public CustomLinkedList(final Node first) { 
        this.head = first;

        Node temp = first;
        this.size = 1;

        while(temp != null && temp.next != null) { 
            temp = temp.next;
            this.size++;
        }

        this.lastElement = temp;
    }   

    /** Add a node at the end */
    public void add(final Object value) { 
        this.size++;

        //If there is no value for head
        if(this.head.value == null) {

            //Set the head's current value
            this.head.value = value;

            //Set the next element to the last one
            this.lastElement = new Node();
            this.head.next = this.lastElement;
        }

        else { 
            this.lastElement.value = value;
            this.lastElement.next = new Node();
            this.lastElement = this.lastElement.next;
        }
    }

    /** More methods will be implemented when the need comes */

    /** Get the total number of elements*/
    public int size() { 
        return this.size;
    }

    /** Get the first node */
    public Node getHead() { 
        return this.head;
    }

    /** Get the last node */
    public Node getLast() { 
        return this.lastElement;
    }
    
    /** To String representation of each item in list*/
    public String toString() { 
        final StringBuilder holder = new StringBuilder("");

        Node top = this.head;

        while(top != null) {
            if(top.value != null) {
                holder.append(top.value.toString() + " ");
            }
            top = top.next;
        }

        return holder.toString();
    }

    public static void main(String[] ryan) { 
        final CustomLinkedList myList = new CustomLinkedList();

        for(String s : ryan) { 
            myList.add(s);
        }

        Node head = myList.getHead();

        while(head != null) {
            System.out.println("Stored Value\t" + head.value);
            head = head.next;
        }

        System.out.println("SIZE " + myList.size());
    }
}
