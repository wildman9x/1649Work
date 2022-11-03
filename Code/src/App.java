public class App {
    public static void main(String[] args) throws Exception {
        // Create a stack and put in an array of integers from 1 to 10
        Stack stack = new Stack(new Integer[] {1, 2, 3, 4, 5, 6, 7, 8, 9, 10});
        System.out.println(stack.toString());
        System.out.println(stack.peek());
        // Push 12 to the stack
        stack.push(12);
        System.out.println(stack.toString());
        // Remove the top element from the stack
        stack.pop();
        System.out.println(stack.toString());
        System.out.println(stack.size());
        // Add a new element to the top of the stack
        stack.push(11);
        System.out.println(stack.peek());
        System.out.println(stack.toString());
        System.out.println(stack.size());
        // Search for the index of 5 in the stack
        System.out.println("The index of 5 is: " + stack.search(5));

        // check if the stack is empty
        System.out.println("Is the stack empty? " + stack.isEmpty());

        // Create a queue and put in an array of integers from 1 to 10
        Queue queue = new Queue(new Integer[] {1, 2, 3, 4, 5, 6, 7, 8, 9, 10});
        System.out.println(queue.toString());
        System.out.println(queue.peek());
        // Enqueue 12 to the queue
        queue.enqueue(12);
        System.out.println(queue.toString());
        // Dequeue the first element from the queue
        queue.dequeue();
        System.out.println(queue.toString());
        System.out.println(queue.size());
        // Add a new element to the end of the queue
        queue.enqueue(11);
        System.out.println(queue.peek());
        System.out.println(queue.toString());
        System.out.println(queue.size());
        // Search for the index of 5 in the queue
        System.out.println("The index of 5 is: " + queue.search(5));
        

        
    }
}
