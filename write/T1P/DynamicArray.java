package T1P;

import java.util.function.Consumer;

public class DynamicArray {
    int size = 0;//所含个数
    int capacity = 8;
    int[] arr = new int[8];

    public void add(int value, int index) {
        if (index < 0 || index > size) {
            System.out.println("出错");
            return;
        } else if (size < capacity) {
            System.arraycopy(arr, index, arr, index + 1, size - index);
            arr[index] = value;
            size++;
        } else if (size == capacity) {
            grow();
            System.arraycopy(arr, index, arr, index + 1, size - index);
            arr[index] = value;
            size++;
        }
    }

    public void grow() {
        capacity += capacity >> 1;
        int[] newArr = new int[capacity];
        System.arraycopy(arr, 0, newArr, 0, size);
        arr = newArr;
    }

    public void foreach(Consumer<Integer> consumer) {
        for (int count = 0; count < size; count++) {
            consumer.accept(arr[count]);
        }
    }

    public void remove(int index) {
        if (index < 0 || index >= size) {
            return;
        }
        System.arraycopy(arr, index + 1, arr, index, size - index - 1);
        size--;
    }

    public void getValue(int index) {
        if (index < 0 || index >= size) {
            System.out.println("出错");
            return;
        }
        System.out.println(arr[index]);
    }
}
