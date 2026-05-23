package T1;

import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.function.Consumer;

public class DoublyLinkedList implements Iterable<Integer> {
    private Node head = new Node(null, 999, null);
    private Node tail = new Node(null, -999, null);

    public DoublyLinkedList() {
        head.next = tail;
        tail.prev = head;
    }

    @Override
    public Iterator<Integer> iterator() {
        return new Iterator<>() {
            Node p = head;

            @Override
            public boolean hasNext() {
                return p.next != tail;
            }

            @Override
            public Integer next() {
                if (!hasNext()) throw new NoSuchElementException();
                p = p.next;
                return p.value;
            }
        };
    }

    public static class Node {
        Node prev;
        int value;
        Node next;

        public Node(Node prev, int value, Node next) {
            this.prev = prev;
            this.value = value;
            this.next = next;
        }
    }

    public Node find(int index) {
        if (index < 0) {
            return null;
        }
        if (head.next == tail) {
            return null;
        }
        if (index == 0)
            return head.next;
        Node p = head.next;
        int count = 0;
        while (p != tail && count < index) {
            p = p.next;
            count++;
        }
        if (p == tail) {
            return null;
        }
        return p;
    }

    public boolean insert(int index, int value) {
        if (index == 0) {
            Node next = head.next;
            Node p = new Node(head, value, next);
            head.next = p;
            next.prev = p;
            return true;
        }
        Node prev = find(index - 1);
        if (prev == null || prev == tail) {
            return false;
        } else {
            Node p = new Node(prev, value, prev.next);
            prev.next.prev = p;
            prev.next = p;
            return true;
        }
    }

    public int remove(int index) {
        Node p = find(index);
        if (p == null)
            return -9999;
        p.next.prev = p.prev;
        p.prev.next = p.next;
        return p.value;
    }

    public void foreach(Consumer<Integer> consumer) {
        Node p = head;
        while (p.next != tail) {
            p = p.next;
            consumer.accept(p.value);
        }
    }

}
