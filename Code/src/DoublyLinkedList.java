public class DoublyLinkedList {
    private Node head;
    private Node tail;
    private int size;
    
    public DoublyLinkedList() {
        head = null;
        tail = null;
        size = 0;
    }
    
    public void add(int data) {
        Node newNode = new Node(data);
        if (head == null) {
            head = newNode;
            tail = newNode;
        } else {
            tail.setNext(newNode);
            newNode.setPrev(tail);
            tail = newNode;
        }
        size++;
    }
    
    public void add(int data, int index) {
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException();
        }
        Node newNode = new Node(data);
        if (index == 0) {
            newNode.setNext(head);
            head.setPrev(newNode);
            head = newNode;
        } else if (index == size) {
            tail.setNext(newNode);
            newNode.setPrev(tail);
            tail = newNode;
        } else {
            Node current = head;
            for (int i = 0; i < index - 1; i++) {
                current = current.getNext();
            }
            newNode.setNext(current.getNext());
            newNode.setPrev(current);
            current.getNext().setPrev(newNode);
            current.setNext(newNode);
        }
        size++;
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
    
    public void remove(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException();
        }
        if (index == 0) {
            head = head.getNext();
            head.setPrev(null);
        } else if (index == size - 1) {
            tail = tail.getPrev();
            tail.setNext(null);
        } else {
            Node current = head;
            for (int i = 0; i < index - 1; i++) {
                current = current.getNext();
            }
            current.setNext(current.getNext().getNext());
            current.getNext().setPrev(current);
        }
        size--;
    }
    
    public int size() {
        return size;
    }

    public String toString() {
        String result = "";
        Node current = head;
        while (current != null) {
            result += current.getData() + " ";
            current = current.getNext();
        }
        return result;
    }
}
