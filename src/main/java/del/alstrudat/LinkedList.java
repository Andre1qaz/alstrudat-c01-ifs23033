package del.alstrudat;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class LinkedList<T> implements Iterable<T> {
    private Node<T> head;
    private Node<T> tail;
    private int size;
    
    private static class Node<T> {
        T data;
        Node<T> next;
        
        Node(T data) {
            this.data = data;
            this.next = null;
        }
    }
    
    public LinkedList() {
        head = null;
        tail = null;
        size = 0;
    }
    
    public int size() {
        return size;
    }
    
    public boolean isEmpty() {
        return size == 0;
    }
    
    public void add(T data) {
        Node<T> newNode = new Node<>(data);
        
        if (isEmpty()) {
            head = newNode;
        } else {
            tail.next = newNode;
        }
        
        tail = newNode;
        size++;
    }
    
    public boolean contains(T data) {
        Node<T> current = head;
        
        while (current != null) {
            if (current.data.equals(data)) {
                return true;
            }
            current = current.next;
        }
        
        return false;
    }
    
    public boolean remove(T data) {
        if (isEmpty()) {
            return false;
        }
        
        if (head.data.equals(data)) {
            head = head.next;
            size--;
            
            if (head == null) {
                tail = null;
            }
            
            return true;
        }
        
        Node<T> current = head;
        while (current.next != null && !current.next.data.equals(data)) {
            current = current.next;
        }
        
        if (current.next != null) {
            if (current.next == tail) {
                tail = current;
            }
            
            current.next = current.next.next;
            size--;
            return true;
        }
        
        return false;
    }
    
    public T get(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);
        }
        
        Node<T> current = head;
        for (int i = 0; i < index; i++) {
            current = current.next;
        }
        
        return current.data;
    }
    
    public void set(int index, T data) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);
        }
        
        Node<T> current = head;
        for (int i = 0; i < index; i++) {
            current = current.next;
        }
        
        current.data = data;
    }
    
    public void clear() {
        head = null;
        tail = null;
        size = 0;
    }
    
    @Override
    public Iterator<T> iterator() {
        return new Iterator<T>() {
            private Node<T> current = head;
            
            @Override
            public boolean hasNext() {
                return current != null;
            }
            
            @Override
            public T next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                
                T data = current.data;
                current = current.next;
                return data;
            }
        };
    }
    
    // For the LinkedListHelper
    Node<T> getHead() {
        return head;
    }
    
    void setHead(Node<T> head) {
        this.head = head;
    }
}
