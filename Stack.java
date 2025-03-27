import java.util.ArrayList;
import java.util.EmptyStackException;

public class Stack<T> {
    
    // Internal storage for stack elements
    private ArrayList<T> elements;
    private int count;

    // Constructor to initialize the stack
    public Stack() {
        elements = new ArrayList<>();
        count = 0;
    }

    // Push item onto the stack
    public void push(T item) {
        elements.add(item); // Add item to the end of the ArrayList
        count++;            // Increment the size
    }

    // Pop item from the stack
    public T pop() {
        if (isEmpty()) {
            throw new EmptyStackException(); // Throw exception if stack is empty
        }
        T item = elements.remove(count - 1); // Get the last item
        count--;                                // Decrement the size
        return item;                            // Return the popped item
    }

    // Peek at the top item without removing it
    public T peek() {
        if (isEmpty()) {
            throw new EmptyStackException(); // Throw exception if stack is empty
        }
        return elements.get(count - 1);      // Return the last item
    }

    // Check if the stack is empty
    public boolean isEmpty() {
        return count == 0;                    // Return true if size is 0
    }

    // Get the current size of the stack
    public int size() {
        return count;                         // Return the size
    }

    // Example usage
    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>();
        stack.push(10);
        stack.push(20);
        stack.push(30);
        
        System.out.println("Top element is: " + stack.peek()); // Should print 30
        System.out.println("Stack size is: " + stack.size());  // Should print 3

        System.out.println("Popped element is: " + stack.pop()); // Should print 30
        System.out.println("Stack size after pop: " + stack.size()); // Should print 2
        
        System.out.println("Is the stack empty? " + stack.isEmpty()); // Should print false
    }
}