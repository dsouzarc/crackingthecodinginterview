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
            if(pointer.next.equals(value) >= 0) {
                //Remove it from the list and add it to a separate list
                //of large values that will be appended at the end

            }
        }
    }

    public static void main(String[] ryan) { 

        final CustomLinkedList list = new CustomLinkedList();
        final Random gen = new Random();

        for(int i = 0; i < 10; i++) { 
            list.add(gen.nextInt(10 * 10));
        }

        final int partitionValue = gen.nextInt((10 * 10) / 2);

        partition(list, partitionValue);

        System.out.println("ORIGINAL\t PARTITION: " + partitionValue + "\n" + list.toString());
    }
}
