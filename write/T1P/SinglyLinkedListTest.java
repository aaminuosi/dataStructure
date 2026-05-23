package T1P;

public class SinglyLinkedListTest {
    static void main(String[] args) {
        SinglyLinkedList list = new SinglyLinkedList();
        list.loop1(System.out::print);
        list.addFirst(1);
        list.addFirst(2);
        list.addFirst(3);
        list.loop1(System.out::print);
        System.out.println();
        list.addFirst(4);
        list.loop1(System.out::print);
        System.out.println();
        SinglyLinkedList.Node n = list.findNode(1);
        System.out.println(n.value);
        list.insert(-1, 0);
        list.insert(-2, 1);
        list.insert(-100, 100);
        list.loop1(System.out::print);
    }
}
