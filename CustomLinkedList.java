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

    /** Constructor from existing list */
    public CustomLinkedList(final CustomLinkedList other) { 
        this(other.getHead());
    }

    /** Add a node at the end */
    public void add(final Object value) { 
        this.size++;

        //If there is no value for head
        if(this.head.value == null) {
            //Set the head's current value
            this.head.value = value;
        }

        else { 
            if(this.lastElement == null) { 
                this.lastElement = new Node(value);
                this.lastElement.previous = this.head;
                this.head.next = this.lastElement;
            }
            else { 
                final Node newestVal = new Node(value);
                this.lastElement.next = newestVal;
                newestVal.previous = this.lastElement;
                this.lastElement = this.lastElement.next;
            }
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

    /** Contains an object */
    public boolean contains(final Object other) { 
        Node temp = this.head;

        while(temp != null) { 
            if(temp.value != null) { 
                if(temp.value.equals(other)) { 
                    return true;
                }
            }

            temp = temp.next;
        }
        return false;
    }

    /** Remove an object */
    public void remove(final Object toRemove) { 
        Node current = this.head;

        while(current.value != null && !current.value.equals(toRemove)) { 
            current = current.next;
        }

        //We went to the end and it's not there
        if(current == null) { 
            return;
        }

        //If it's the first element
        if(current.equals(this.head)) { 
            
            //If there are no other elements
            if(this.head.next == null) { 
                this.head.value = null;
                this.size--;
                return;
            }

            //Only two elements, last becomes first
            else if(this.head.next.equals(this.lastElement) || this.size == 2) { 
                this.head.value = this.lastElement.value;
                this.head.next = null;
                this.lastElement = null;
                this.size--;
                return;
            }

            //More than two elements, first becomes second
            else { 
                this.head.value = this.head.next.value;
                this.head.next = this.head.next.next;

                if(this.head.next.next != null) { 
                    this.head.next.next.previous = this.head;
                }
                this.size--;
                return;
            }
        }

        else { 
            current.previous = current.next;
            current.next.previous = current.previous;
            this.size--;
        }
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

        //Remove the 2nd item
        myList.remove(ryan[0]);
        myList.remove(ryan[1]);
        myList.remove(ryan[2]);

        myList.add(ryan[0]);
        System.out.println("after removing an element: " + myList.size());

        head = myList.getHead();

        while(head != null) { 
            System.out.println("Stored Value\t" + head.value);
            head = head.next;
        }
    }
}
