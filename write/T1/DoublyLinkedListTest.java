package T1;

public class DoublyLinkedListTest {
    static void main(String[] args) {
        DoublyLinkedList list = new DoublyLinkedList();


        list.insert(0, 1);
        list.insert(1, 2);
        list.insert(2, 3);
        System.out.println();
        System.out.println("____________");
        list.foreach(System.out::println);

        list.insert(-1, 99);
        list.insert(100, 999);
        System.out.println();
        System.out.println("____________");
        list.foreach(System.out::println);

        list.insert(0, -3);
        list.insert(2, -2);
        System.out.println();
        System.out.println("____________");
        list.foreach(System.out::println);

        for (Integer i : list) {
            System.out.print(i + " ");
        }
        System.out.println("____________");
        list.remove(-1);
        list.remove(100);
        list.remove(0);
        list.remove(4);
        list.remove(100);
        for (Integer i : list) {
            System.out.print(i + " ");
        }

    }


}
