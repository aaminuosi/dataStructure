
package D1;

/**
 * DynamicArray功能测试类
 * 测试动态数组的各种功能：添加、删除、获取、遍历等
 */
public class DynamicArrayTest {
    public static void main(String[] args) {
        DynamicArray array = new DynamicArray();

        // 测试1：添加元素
        System.out.println("=== 测试1：添加元素 ===");
        array.addList(10);
        array.addList(20);
        array.addList(30);
        array.addList(40);
        array.addList(50);
        System.out.print("添加5个元素后：");
        array.forEach(System.out::print);
        System.out.println();

        // 测试2：在指定位置插入元素
        System.out.println("\n=== 测试2：在指定位置插入元素 ===");
        array.add(2, 25);
        System.out.print("在位置2插入25后：");
        array.forEach(System.out::print);
        System.out.println();

        // 测试3：获取元素
        System.out.println("\n=== 测试3：获取元素 ===");
        System.out.println("位置0的元素：" + array.get(0));
        System.out.println("位置3的元素：" + array.get(3));

        // 测试4：删除元素
        System.out.println("\n=== 测试4：删除元素 ===");
        int removed = array.remove(2);
        System.out.println("删除位置2的元素：" + removed);
        System.out.print("删除后数组：");
        array.forEach(System.out::print);
        System.out.println();

        // 测试5：使用迭代器遍历
        System.out.println("\n=== 测试5：使用迭代器遍历 ===");
        System.out.print("使用迭代器遍历：");
        for (int num : array) {
            System.out.print(num + " ");
        }
        System.out.println();

        // 测试6：使用流操作
        System.out.println("\n=== 测试6：使用流操作 ===");
        System.out.print("使用流遍历：");
        array.stream().forEach(num -> System.out.print(num + " "));
        System.out.println();

        // 测试7：测试动态扩容
        System.out.println("\n=== 测试7：测试动态扩容 ===");
        DynamicArray expandArray = new DynamicArray();
        System.out.println("添加20个元素测试扩容：");
        for (int i = 1; i <= 20; i++) {
            expandArray.addList(i);
        }
        System.out.print("扩容后数组：");
        expandArray.forEach(System.out::print);
        System.out.println();

        // 测试8：使用foreach方法
        System.out.println("\n=== 测试8：使用foreach方法 ===");
        System.out.println("使用foreach方法遍历并打印每个元素：");
        array.foreach(num -> System.out.println("元素：" + num));

        System.out.println("\n=== 所有测试完成 ===");
    }
}
