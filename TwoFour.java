import java.util.Random;

/** 
 * Written by Ryan D'souza
 * Cracking the Coding Interview 2.4
 * Partitions a list of values around X
 * so that all values less than X are in front of it
 * and all values greater than X are after it */

public class TwoFour { 
    public static CustomLinkedList partition(CustomLinkedList list, final Object value) { 
        Node forGreater = null;
        Node forLess = null;
        Node pointer = list.getHead();

        while(pointer != null && pointer.next != null) { 
           if(compareTo(pointer.value, value) >= 0) {
            if(forGreater == null) { 
                forGreater = new Node(pointer.value);
            }
            else { 
                forGreater = new Node(pointer.value, forGreater);
            }
           }
           else { 
               if(forLess == null) { 
                   forLess = new Node(pointer.value);
               }
               else { 
                   forLess = new Node(pointer.value, forLess);
               }
           }
           
           pointer = pointer.next;
        }

        forLess.next = forGreater;

        return new CustomLinkedList(forLess);
    }

    public static int compareTo(Object one, final Object two) { 
        return one.toString().compareTo(two.toString());
    }

    public static void main(String[] ryan) { 

        CustomLinkedList list = new CustomLinkedList();
        final Random gen = new Random();
        final int SIZE = 10;

        for(int i = 0; i < SIZE; i++) { 
            list.add(gen.nextInt(SIZE * SIZE));
        }

        final int partitionValue = gen.nextInt((SIZE * SIZE) / 2);
        System.out.println("ORIGINAL\t PARTITION: " + partitionValue + "\n" + list.toString());

        list = partition(list, partitionValue);

        System.out.println("NEW\n" + list.toString());
    }
}
