package T1;

public class SinglyLinkedListTest {
    static void main(String[] args) {
        SinglyLinkedList List = new SinglyLinkedList();
        List.add(1, 0);
        List.add(2, 1);
        List.add(2, 2);
        List.add(3, 3);
        List.add(4, 4);
        List.add(5, 5);
        List.add(40, 4);
        List.add(6, 10);

        List.loop1(System.out::print);
    }
}
