/** 
 * Written by Ryan D'souza
 * Cracking the Coding Interview
 * Custom Stack data structure that also keeps track of min value
 *
 * Unfortunately, I had to look at the answer for this one. I had difficulty
 * coming up with a program that could keep track of the 2nd and 3rd smallest values
 * ex. if you pop the smallest value from the stack, how do you know the next smallest
 * value without iterating through
 * */

public class ThreeTwo extends CustomStack { 
    private final CustomStack stack2;

    public ThreeTwo() { 
        this.stack2 = new CustomStack();
    }

    public Object min() { 
        if(this.stack2.getSize() == 0) { 
            return Integer.MAX_VALUE;
        }
        return this.stack2.peek();
    }

    public Object pop() { 
        final Object value = super.pop();

        if(value.toString().equals(this.min().toString())) { 
            this.stack2.pop();
        }
        return value;
    }

    public void add(final Object obj) { 
        if(obj.toString().compareTo(this.min().toString()) <= 0) { 
            this.stack2.add(obj);
        }
        super.add(obj);
    }
}
