import java.util.ArrayList;

public class DoublyLinkedList {
    private Node head;
    private Node tail;
    private int size;

    public DoublyLinkedList() {
        head = null;
        tail = null;
        size = 0;
    }

    // take in an array of any type and create a new DoublyLinkedList
    // with the same elements as the array
    public DoublyLinkedList(Object[] arr) {
        this();
        for (Object o : arr) {
            add(o);
        }
    }

    public void add(Object data) {
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

    public ArrayList<Integer> search(Object data) {
        Node current = head;
        ArrayList<Integer> indices = new ArrayList<Integer>();
        int index = 0;
        while (current != null) {
            if (current.getData().equals(data)) {
                indices.add(index);
            }
            current = current.getNext();
            index++;
        }
        return indices;
    }

    public void add(Object data, int index) {
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

    public void removeFirst() {
        // remove(0);
        if (size == 0) {
            throw new IndexOutOfBoundsException();
        }
        Node temp = head;
        head = head.getNext();
        head.setPrev(null);
        temp.setNext(null);
        size--;

    }

    public int size() {
        return size;
    }

    @Override
    public String toString() {
        String result = "";
        Node current = head;
        ArrayList<Object> list = new ArrayList<Object>();
        while (current != null) {
            list.add(current.getData());
            current = current.getNext();
        }
        result = list.toString();
        return result;
    }
}
