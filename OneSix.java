/** Written by Ryan D'souza
 * Cracking the Coding Interview 1.6
 * Given an image represented by an NxN matrix, 
 * where each pixel in the image is 4 bytes, 
 * write a method to rotate the image by 90 degrees Can you do this in place? */
import java.io.BufferedReader;
import java.io.FileReader;

 public class OneSix { 

     public short[][] rotate90(final short[][] original) { 

         //Divide by 2 because when we rotate the top half, we rotate
         //the bottom half
         for(short i = 0; i < original.length / 2; i++) { 
             for(short y = 0; y < original[i].length / 2; y++) { 
                 final short valB = original[i][y];
                 final short replace = original[i][original[i].length - y];

                 original[i][original[i].length - y] = valB;
                 original[i][y] = replace;
             }
         }

         return original;
     }
 }
