// Implement queue using doubly linked list
public class Queue {
    private DoublyLinkedList list;
    
    public Queue() {
        list = new DoublyLinkedList();
    }

    // take in an array of any type and create a new Queue
    // with the same elements as the array
    public Queue(Object[] arr) {
        list = new DoublyLinkedList(arr);
    }
    
    public void enqueue(int data) {
        list.add(data);
    }
    
    public Object dequeue() {
        Object data = list.get(0);
        list.removeFirst();
        return data;
    }
    
    public Object peek() {
        return list.get(0);
    }
    
    public boolean isEmpty() {
        return list.size() == 0;
    }
    
    public int size() {
        return list.size();
    }

    public int search(Object data) {
        return list.search(data);
    }
    
    @Override
    public String toString() {
        return list.toString();
    }
}
