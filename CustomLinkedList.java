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

    public CustomLinkedList(final Node val) { 
        this.head = val;

        Node temp = val;

        while(temp != null && temp.next != null) { 
            size++;
            temp = temp.next;
        }
    }

    public void add(final Object value) { 

        if(head.value == null) { 
            head.value = value;
        }

        else { 
            final Node nodeVal = new Node(value);
        
            //Node to get to last node
            Node toEnd = this.head;

            while(toEnd.next != null) { 
                toEnd = toEnd.next;
            }

            //Add newest node to end of list
            toEnd.next = nodeVal;
        }
        size++;
    }

    /** More methods will be implemented when the need comes */

    public int size() { 
        return this.size;
    }

    public Node getHead() { 
        return this.head;
    }

    public String toString() { 
        final StringBuilder holder = new StringBuilder("");

        Node top = this.head;

        while(top != null) { 
            holder.append(top.value.toString() + " ");
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
    }
}
