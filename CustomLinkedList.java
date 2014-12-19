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

        //If it's the first element
        if(this.head.value.equals(toRemove)) { 
            if(this.head.next != null) { 
                //Replace
                this.head.value = this.head.next.value;
                this.head.next = this.head.next.next;

                if(this.head.next != null) { 
                    this.head.next.previous = null;
                }
                this.size--;
            }
            else { 
                this.head.value = null;
                this.head.next = null;
                this.size--;
            }

            if(this.size == 0) { 
                this.lastElement = null;
            }
            else if(this.size == 1) { 
                this.head.next = this.lastElement;
            }

            return;
        }

        Node temp = this.head;
        while(temp != null) { 
            if(temp.value != null) { 
                if(temp.value.equals(toRemove)) { 
                    //If this isn't the first element
                    if(temp.previous != null) { 
                        //Get the previous node and make its next item be the current next item
                        //thereby removing this element
                        temp.previous.next = temp.next;
                        temp.next.previous = temp.previous;
                        
                        this.size--;
                    }
                    else { 
                    }
                }
            }
            temp = temp.next;
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
