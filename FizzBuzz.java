/** 
 * Written by Ryan D'souza
 * Prints numbers from 1 to N
 * For multiples of 3, prints "Fizz" instead of number
 * For multiples of 5, prints "Buzz" instead of number
 * For multiples of both 3 and 5, prints "FizzBuzz" */

public class FizzBuzz { 
    public static void main(String[] ryan) { 

        //Testing number
        final int N = 50;

        for(int i = 1; i <= N; i++) { 

            //If multiple of 3 and 5
            if(i % (3 * 5) == 0) { 
                System.out.println("FizzBuzz");
            }

            //Just multiple of 5
            else if(i % 5 == 0) { 
                System.out.println("Buzz");
            }

            //Or multiple of 3
            else if(i % 3 == 0) { 
                System.out.println("Fizz");
            }

            //Or any other number
            else { 
                System.out.println(i);
            }
        }
    }
}
