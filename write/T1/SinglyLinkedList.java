package T1;

import java.util.function.Consumer;

public class SinglyLinkedList {
    Node head = null;

    public static class Node {
        int value;
        Node next;

        public Node(int value, Node next) {
            this.value = value;
            this.next = next;
        }
    }

    public Node findLast() {
        if (head == null) return null;
        Node p;
        for (p = head; p.next != null; p = p.next) {
        }
        return p;
    }

    public boolean addFirst(int value) {

        head = new Node(value, head);
        return true;
    }


    public boolean add(int value, int index) {
        if (index < 0) {
            return false;
        } else if (index == 0) {
            addFirst(value);
            return true;
        }
        int count = 0;
        Node p = head;
        if (p == null) {
            return false;
        }
        for (p = head; p != null; p = p.next, count++) {
            if (count > index) {
                return false;
            } else if (count == index - 1) {
                p.next = new Node(value, p.next);
                return true;
            }
        }
        return false;
    }

    public void loop1(Consumer<Integer> consumer) {
        for (Node p = head; p != null; p = p.next) {
            consumer.accept(p.value);
        }
    }

}
