import java.util.ArrayList;

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

    public void push(Object data) {
        list.addFirst(data);
    }

    public Object pop() {
        Object data = list.get(0);
        list.removeFirst();
        return data;
    }

    public ArrayList<Integer> search(Object data) {
        ArrayList<Integer> indices = new ArrayList<Integer>(list.search(data));
        return indices;
    }

    public Object peek() {
        return list.getHead();
    }

    // public void reverseStack() {
    //     Stack newStack = new Stack();
    //     while (!this.isEmpty()) {
    //         newStack.push(this.pop());
    //     }
    //     this.list = newStack.list;
    // }

    public void reverseStack() {
        Node prev, current, next;
        prev = null;
        current = list.getHeadNode();
        next = current.getNext();
        while (next != null) {
            current.setNext(prev);
            prev = current;
            current = next;
            next = next.getNext();
        }
        current.setNext(prev);
        list.setHead(current);
    }

    public void reverseStackRecursion() {
        if (this.isEmpty()) {
            return;
        }
        Object data = this.pop();
        this.reverseStackRecursion();
        this.insertAtBottom(data);
    }

    public void insertAtBottom(Object data) {
        if (this.isEmpty()) {
            this.push(data);
            return;
        }
        Object temp = this.pop();
        this.insertAtBottom(data);
        this.push(temp);
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
