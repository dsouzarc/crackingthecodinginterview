import java.util.Random;

/** 
 * Written by Ryan D'souza
 * Cracking the Coding Interview 2.4
 * Partitions a list of values around X
 * so that all values less than X are in front of it
 * and all values greater than X are after it */

public class TwoFour { 
    public static void partition(CustomLinkedList list, final Object value) { 
        Node forGreater = null;
        Node pointer = list.getHead();

        while(pointer != null && pointer.next != null) { 
            //If the value is greater than or eqaul to this
            if(pointer.next.value.toString().compareTo(value.toString()) >= 0) {
                //Remove it from the list and add it to a separate list
                //of large values that will be appended at the end
                Object tempValue = pointer.next.value;
                
                //Skip over this element
                pointer.next = pointer.next.next;

                //Add new version of this to end
                forGreater = new Node(tempValue, forGreater);
            }
            pointer = pointer.next;
            
        }

        //Add greater elements at end
        //pointer.next = forGreater;
    }

    public static void main(String[] ryan) { 

        final CustomLinkedList list = new CustomLinkedList();
        final Random gen = new Random();
        final int SIZE = 10;

        for(int i = 0; i < SIZE; i++) { 
            list.add(gen.nextInt(SIZE * SIZE));
        }

        final int partitionValue = gen.nextInt((SIZE * SIZE) / 2);
        System.out.println("ORIGINAL\t PARTITION: " + partitionValue + "\n" + list.toString());

        partition(list, partitionValue);

        System.out.println("NEW\n" + list.toString());
    }
}
