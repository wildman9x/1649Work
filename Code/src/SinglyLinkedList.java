import java.util.ArrayList;

public class SinglyLinkedList {
    private Node head;
    private Node tail;
    private int size;
    
    public SinglyLinkedList() {
        this.head = null;
        this.tail = null;
        this.size = 0;
    }

    // take in an array of any type and create a new SinglyLinkedList
    // with the same elements as the array
    public SinglyLinkedList(Object[] arr) {
        this();
        for (Object o : arr) {
            add(o);
        }
    }
    
    public void add(Object data) {
        Node newNode = new Node(data);
        if (head == null) {
            head = newNode;
            tail = head;
        } else {
            tail.setNext(newNode);
            tail = tail.getNext();
        }
        size++;
    }

    // get tail
    public Object getTail() {
        return tail.getData();
    }

    // get head
    public Object getHead() {
        return head.getData();
    }
    
    public void add(Object data, int index) {
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException();
        }
        Node newNode = new Node(data);
        if (index == 0) {
            newNode.setNext(head);
            head = newNode;
            if (tail == null) {
                tail = head;
            }
        } else if (index == size) {
            tail.setNext(newNode);
            tail = newNode;
        } else {
            Node current = head;
            for (int i = 0; i < index - 1; i++) {
                current = current.getNext();
            }
            newNode.setNext(current.getNext());
            current.setNext(newNode);
            // if the tail is null, set the tail to the new node
            
        }
        
        size++;
    }

    public void addFirst(Object data) {
        add(data, 0);
    }
    
    public Object get(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException();
        }
        Node current = head;
        for (int i = 0; i < index; i++) {
            current = current.getNext();
        }
        return current.getData();
    }
    
    

    public void removeLast() {
        // remove(size - 1);
        if (size == 0) {
            throw new IndexOutOfBoundsException();
        }
        if (size == 1) {
            head = null;
            tail = null;
        } else {
            Node current = head;
            for (int i = 0; i < size - 2; i++) {
                current = current.getNext();
            }
            current.setNext(null);
            tail = current;
        }
        size--;
    }

    public void removeFirst() {
        if (size == 0) {
            throw new IndexOutOfBoundsException();
        }
        if (size == 1) {
            head = null;
            tail = null;
        } else {
            head = head.getNext();
        }
        size--;
    }
    
    public int size() {
        return size;
    }

    // return the index of the first occurrence of the data
    public int search(Object data) {
        Node current = head;
        for (int i = 0; i < size; i++) {
            if (current.getData().equals(data)) {
                return i;
            }
            current = current.getNext();
        }
        return -1;
    }
    
    public boolean isEmpty() {
        return size == 0;
    }
    
    public void clear() {
        head = null;
        tail = null;
        size = 0;
    }
    
    public void print() {
        Node current = head;
        while (current != null) {
            System.out.print(current.getData() + " ");
            current = current.getNext();
        }
        System.out.println();
    }

    @Override
    public String toString() {
        String s = "";
        Node current = head;
        ArrayList<Object> list = new ArrayList<>();
        while (current != null) {
            list.add(current.getData());
            current = current.getNext();
        }
        s = list.toString();
        return s;
    }
}
