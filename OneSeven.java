/** Written by Ryan D'souza
 * Cracking the Coding Interview 1.7
 * Write an algorithm such that if 
 * an element in an MxN matrix is 0, 
 * its entire row and column is set to 0 */

public class OneSeven { 
    public static void setTo0(final int[][] matrix) { 
        //Unfortunately, I had to look at the solution for this one
        //But I'm retyping it from memory 

        //We need to keep track of the 0s we change 
        final int[] rows = new int[matrix.length];
        final int[] columns = new int[matrix[0].length];

        for(int i = 0; i < matrix.length; i++) { 
            for(int y = 0; y < matrix[i].length; y++) { 

                //Store the values
                if(matrix[i][y] == 0) { 
                    rows[i] = 1;
                    columns[y] = 1;
                }
            }
        }

        //Update the array with all the 0s
        for(int i = 0; i < matrix.length; i++) { 
            for(int y = 0; y < matrix[i].length; y++) { 
                if(rows[i] == 1 || columns[y] == 1) { 
                    matrix[i][y] = 0;
                }
            }
        }
    }
}
