package T1;

import java.util.function.Consumer;

public class DynamicArray {
    int capacity = 8;
    int size = 0;
    int[] arr = new int[capacity];

    public void add(int value, int index) {
        if (index < 0 || size < index) {
            System.out.println("出错");
            return;
        }
        if (size == capacity) {
            capacity += capacity >> 1;
            int[] newArr = new int[capacity];
            System.arraycopy(arr, 0, newArr, 0, size);
            arr = newArr;
        }
        System.arraycopy(arr, index, arr, index + 1, size - index);
        arr[index] = value;
        size++;
    }

    public void foreach(Consumer<Integer> consumer) {
        for (int i = 0; i < size; i++) {
            consumer.accept(arr[i]);
        }
    }

    public void remove(int index) {
        if (index < 0 || size <= index) {
            System.out.println("出错");
            return;
        }
        System.arraycopy(arr, index + 1, arr, index, size - index - 1);
        size--;
    }
}
