package T1P;

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

    public void addFirst(int value) {
        head = new Node(value, head);
    }

    public Node findNode(int index) {
        Node p = head;
        int count = 0;
        while (p != null) {
            if (count == index) {
                return p;
            } else if (count > index) {
                return null;
            }
            p = p.next;
            count++;
        }
        return null;
    }

    public void insert(int value, int index) {
        if (index < 0) {
            return;
        } else if (index == 0) {
            addFirst(value);
            return;
        }
        Node prev = findNode(index - 1);
        if (prev == null) {
            return;
        } else {
            Node p = new Node(value, prev.next);
            prev.next = p;
        }
    }

    public void loop1(Consumer<Integer> consumer) {
        Node p = head;
        if (p == null) {
            return;
        }
        for (p = head; p.next != null; p = p.next) {
            consumer.accept(p.value);
        }
        consumer.accept(p.value);
    }


}
