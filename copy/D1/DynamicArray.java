package D1;

import java.util.Arrays;
import java.util.Iterator;
import java.util.function.Consumer;
import java.util.stream.IntStream;

/**
 * 动态数组类
 * 实现了Iterable接口，支持foreach循环和迭代器遍历
 * 提供了动态扩容、添加、删除、查询等基本操作
 */
public class DynamicArray implements Iterable<Integer> {
    /**
     * 数组当前元素个数
     */
    private int size = 0;
    /**
     * 数组当前容量
     */
    private int capacity = 8;
    /**
     * 存储元素的数组
     */
    private int[] array = {};

    /**
     * 在数组末尾添加元素
     *
     * @param element 要添加的元素
     */
    public void addList(int element) {
        add(size, element);
    }

    /**
     * 在指定位置插入元素
     *
     * @param index   插入位置
     * @param element 要插入的元素
     */
    public void add(int index, int element) {
        checkAndGrow();

        if (index >= 0 && index <= size) {
            System.arraycopy(array, index, array, index + 1, size - index);
        }
        array[index] = element;
        size++;
    }

    /**
     * 检查并扩展数组容量
     * 当数组大小为0时初始化数组，当数组大小达到容量限制时进行扩容
     * 扩容策略为当前容量的1.5倍
     */
    private void checkAndGrow() {
        // 如果数组大小为0，则进行初始化
        if (size == 0) {
            array = new int[capacity];
        } else if (size == capacity) {
            capacity += capacity >> 1;
            int[] newArray = new int[capacity];
            System.arraycopy(array, 0, newArray, 0, size);
            array = newArray; // 将扩容后的新数组赋值给array
        }
    }

    /**
     * 获取指定位置的元素
     *
     * @param index 元素位置
     * @return 指定位置的元素值
     */
    public int get(int index) {
        return array[index];
    }

    /**
     * 遍历数组，对每个元素执行指定操作
     *
     * @param consumer 对元素执行的操作
     */
    public void foreach(Consumer<Integer> consumer) {
        for (int i = 0; i < size; i++) {
            consumer.accept(array[i]);
        }
    }

    /**
     * 返回数组的迭代器
     *
     * @return 整数迭代器
     */
    @Override
    public Iterator<Integer> iterator() {
        return new Iterator<Integer>() {
            int i = 0;

            @Override
            public boolean hasNext() {
                return i < size;
            }

            @Override
            public Integer next() {
                return array[i++];
            }
        };
    }

    /**
     * 返回数组的流
     *
     * @return 整数流
     */
    public IntStream stream() {
        return IntStream.of(Arrays.copyOfRange(array, 0, size));
    }

    /**
     * 删除指定位置的元素
     *
     * @param index 要删除的元素位置
     * @return 被删除的元素值
     */
    public int remove(int index) {
        int removed = array[index];
        if (index < size - 1) {
            System.arraycopy(array, index + 1, array, index, size - index - 1);
        }
        size--;
        return removed;
    }
}
