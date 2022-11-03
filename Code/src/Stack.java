// Implement a stack using a singly linked list
public class Stack {
    private SinglyLinkedList list;
    
    public Stack() {
        list = new SinglyLinkedList();
    }

    // take in an array of any type and create a new Stack
    // with the same elements as the array
    public Stack(Object[] arr) {
        list = new SinglyLinkedList(arr);
    }
    
    public void push(int data) {
        list.addFirst(data);
    }
    
    public Object pop() {
        Object data = list.get(0);
        list.removeFirst();
        return data;
    }

    public Object search(Object data) {
        return list.search(data);
    }
    
    public Object peek() {
        // return list.get(list.size() - 1);
        return list.getTail();
    }
    
    public boolean isEmpty() {
        return list.size() == 0;
    }
    
    public int size() {
        return list.size();
    }
    
    @Override
    public String toString() {
        return list.toString();
    }


}
