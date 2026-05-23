package T1P;

public class DynamicArrayTest {
    static void main(String[] args) {
        DynamicArray array = new DynamicArray();
        array.add(1, 0);
        array.add(3, 1);
        array.add(4, 2);
        array.add(5, 3);
        array.add(6, 4);
        array.add(8, 5);
        array.add(9, 6);
        array.add(5, 7);
        array.add(1, 8);
        array.add(1, 9);
        array.add(2, 6);
        array.foreach(System.out::print);
        System.out.println();
        array.remove(7);
        array.foreach(System.out::print);
        System.out.println();
        array.remove(-1);
        array.foreach(System.out::print);
        array.remove(111);
        System.out.println();
        array.foreach(System.out::print);
    }
}
