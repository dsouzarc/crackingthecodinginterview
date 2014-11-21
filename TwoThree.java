/**
 * Written by Ryan D'souza
 * Cracking the Coding Interview 2.3
 * Deletes the middle node from a SinglyLinkedList given
 * only access to that node*/

public class TwoThree { 
    public static void deleteNode(final Node toDelete) { 
        
        //Set this value to the next node's value
        toDelete.value = toDelete.next.value;
        toDelete.next = toDelete.next.next;
    }
}
