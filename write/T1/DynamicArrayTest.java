package T1;

public class DynamicArrayTest {
    static void main(String[] args) {
        DynamicArray array = new DynamicArray();
        array.add(1, 0);
        array.add(1, 1);
        array.add(1, 2);
        array.add(1, 3);
        array.add(1, 4);
        array.add(1, 5);
        array.add(1, 6);
        array.add(1, 7);
        array.add(1, 8);
        array.add(1, 0);

        array.foreach(System.out::print);
    }
}
