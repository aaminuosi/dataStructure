
package D1;

/**
 * SinglyLinkedList功能测试类
 * 测试单链表的各种功能：头部添加、尾部添加、插入、删除、获取、遍历等
 */
public class SinglyLinkedListTest {
    public static void main(String[] args) {
        SinglyLinkedList list = new SinglyLinkedList();

        // 测试1：头部添加元素
        System.out.println("=== 测试1：头部添加元素 ===");
        list.addFirst(10);
        list.addFirst(20);
        list.addFirst(30);
        System.out.print("头部添加30, 20, 10后：");
        list.loop1(System.out::print);
        System.out.println();

        // 测试2：尾部添加元素
        System.out.println("\n=== 测试2：尾部添加元素 ===");
        list.addLast(40);
        list.addLast(50);
        System.out.print("尾部添加40, 50后：");
        list.loop2(System.out::print);
        System.out.println();

        // 测试3：获取指定位置元素
        System.out.println("\n=== 测试3：获取指定位置元素 ===");
        System.out.println("位置0的元素：" + list.get(0));
        System.out.println("位置2的元素：" + list.get(2));
        System.out.println("位置4的元素：" + list.get(4));
        System.out.println("越界位置10的元素：" + list.get(10));

        // 测试4：在指定位置插入元素
        System.out.println("\n=== 测试4：在指定位置插入元素 ===");
        list.insert(2, 25);
        System.out.print("在位置2插入25后：");
        list.loop1(System.out::print);
        System.out.println();

        // 测试5：在头部插入元素
        System.out.println("\n=== 测试5：在位置0插入元素 ===");
        list.insert(0, 5);
        System.out.print("在位置0插入5后：");
        list.loop1(System.out::print);
        System.out.println();

        // 测试6：删除头部元素
        System.out.println("\n=== 测试6：删除头部元素 ===");
        list.removeFirst();
        System.out.print("删除头部元素后：");
        list.loop1(System.out::print);
        System.out.println();

        // 测试7：删除指定位置元素
        System.out.println("\n=== 测试7：删除指定位置元素 ===");
        list.remove(2);
        System.out.print("删除位置2的元素后：");
        list.loop1(System.out::print);
        System.out.println();

        // 测试8：使用迭代器遍历
        System.out.println("\n=== 测试8：使用迭代器遍历 ===");
        System.out.print("使用迭代器遍历：");
        for (int num : list) {
            System.out.print(num + " ");
        }
        System.out.println();

        // 测试9：空链表操作
        System.out.println("\n=== 测试9：空链表操作 ===");
        SinglyLinkedList emptyList = new SinglyLinkedList();
        System.out.print("空链表遍历：");
        emptyList.loop1(System.out::print);
        System.out.println();
        System.out.println("空链表获取越界元素：");
        emptyList.get(0);
        System.out.println("空链表删除头部元素：");
        emptyList.removeFirst();

        // 测试10：单元素链表操作
        System.out.println("\n=== 测试10：单元素链表操作 ===");
        SinglyLinkedList singleList = new SinglyLinkedList();
        singleList.addFirst(100);
        System.out.print("单元素链表：");
        singleList.loop1(System.out::print);
        System.out.println();
        singleList.removeFirst();
        System.out.print("删除唯一元素后：");
        singleList.loop1(System.out::print);
        System.out.println();

        // 测试11：尾部添加到空链表
        System.out.println("\n=== 测试11：尾部添加到空链表 ===");
        SinglyLinkedList newList = new SinglyLinkedList();
        newList.addLast(1);
        newList.addLast(2);
        newList.addLast(3);
        System.out.print("空链表尾部添加1, 2, 3后：");
        newList.loop1(System.out::print);
        System.out.println();

        // 测试12：越界插入测试
        System.out.println("\n=== 测试12：越界插入测试 ===");
        list.insert(100, 999);
        System.out.print("越界插入后链表不变：");
        list.loop1(System.out::print);
        System.out.println();

        // 测试13：越界删除测试
        System.out.println("\n=== 测试13：越界删除测试 ===");
        list.remove(100);
        System.out.print("越界删除后链表不变：");
        list.loop1(System.out::print);
        System.out.println();

        System.out.println("\n=== 所有测试完成 ===");
    }
}
