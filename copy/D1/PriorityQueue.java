package D1;
//如果从索引0开始存储节点数据
//节点i的父节点为floor((i一1)/2)，当i>0时
//节点i的左子节点为2i十1，右子节点为 2i十2，当然它们得<size

//如果从索引1开始存储节点数据
//节点i的父节点为 floor(i/2)，当i>1时
//节点i的左子节点为2i，右子节点为2i十1，同样得<size
public class PriorityQueue<E extends Priority> implements Queue<E> {
    Priority[] array;
    int size = 0;

    public PriorityQueue(int capacity) {
        array = new Priority[capacity];
    }

    //1.入堆新元素，加入到数组末尾（索引位置child）
    //2.不断比较新加元素与它父节点（parent）优先级
    //-如果父节点优先级低，则向下移动，并找到下一个parent-直至父节点优先级更高或child==0为止
    @Override
    public boolean offer(E value) {
        if (isFull())
            return false;
        int child = size++;
        int parent = (child - 1) / 2;
        while (child > 0 && value.priority() > array[parent].priority()) {
            array[child] = array[parent];
            child = parent;
            parent = (child - 1) / 2;
        }
        array[child] = value;
        return true;
    }

    @Override
    public E poll() {
        if (isEmpty()) {
            return null;
        }
        swap(0, size - 1);
        size--;
        Priority e = array[size];
        array[size] = null;
        down(0);
        return (E) e;
    }

    private void down(int parent) {
        int left = 2 * parent + 1;
        int right = left + 1;
        int max = parent;
        if (left < size && array[left].priority() > array[max].priority())
            max = left;
        if (right < size && array[right].priority() > array[max].priority())
            max = right;
        if (max != parent) {
            swap(max, parent);
            down(max);
        }
    }

    private void swap(int i, int j) {
        Priority t = array[i];
        array[i] = array[j];
        array[j] = t;
    }

    @Override
    public E peek() {
        if (isEmpty()) {
            return null;
        }
        return (E) array[0];
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public boolean isFull() {
        return size == array.length;
    }
}
