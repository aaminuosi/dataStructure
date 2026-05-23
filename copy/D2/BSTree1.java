package D2;
//public class BSTree1<T extends Comparable<T>> {
//    BSTNode<T> root;
//
//    static class BSTNode<T> {
//        T key;
//        Object value;
//        BSTNode<T> left;
//        BSTNode<T> right;
//
//        public BSTNode(T key) {
//            this.key = key;
//        }
//
//        public BSTNode(T key, Object value) {
//            this.key = key;
//            this.value = value;
//        }
//
//        public BSTNode(T key, Object value, BSTNode<T> left, BSTNode<T> right) {
//            this.key = key;
//            this.value = value;
//            this.left = left;
//            this.right = right;
//        }
//    }
//
//    public Object getE(T key) {
//        BSTNode<T> node = root;
//        while (node != null) {
//            int result = key.compareTo(node.key);
//            if (result < 0) {
//                node = node.left;
//            } else if (result > 0) {
//                node = node.right;
//            } else {
//                return node.value;
//            }
//        }
//        return null;
//    }

public class BSTree1<K extends Comparable<K>, V> {
    private Node<K, V> root;

    // 节点内部类：键 + 值
    private static class Node<K, V> {
        K key;
        V value;
        Node<K, V> left;
        Node<K, V> right;

        Node(K key, V value) {
            this.key = key;
            this.value = value;
        }
    }

    /**
     * 根据 key 获取 value（迭代实现，避免栈溢出）
     */
    public V get(K key) {
        if (key == null) throw new IllegalArgumentException("key 不能为 null");
        Node<K, V> node = root;
        while (node != null) {
            int cmp = key.compareTo(node.key);
            if (cmp < 0) {
                node = node.left;
            } else if (cmp > 0) {
                node = node.right;
            } else {
                return node.value;
            }
        }
        return null;   // 未找到
    }

    /**
     * 递归查找指定 key 对应的 value
     *
     * @param node 当前子树的根节点
     * @param key  要查找的键
     * @return 找到返回对应的 value，否则返回 null
     */
    private V doGet(Node<K, V> node, K key) {
        // 递归基：走到空节点说明没找到
        if (node == null) {
            return null;
        }
        int cmp = key.compareTo(node.key);
        if (cmp < 0) {
            // key 比当前节点小 → 到左子树递归查找
            return doGet(node.left, key);
        } else if (cmp > 0) {
            // key 比当前节点大 → 到右子树递归查找
            return doGet(node.right, key);
        } else {
            // 找到了，返回当前节点的 value
            return node.value;
        }
    }
//    public Object get(T key) {
//        return doGet(root, key);
//    }
//
//    private Object doGet(BSTNode<T> node, T key) {
//        if (node == null) {
//            return null;
//        }
//        int result = key.compareTo(node.key);
//        if (result < 0) {
//            return doGet(node.left, key);
//        } else if (result > 0) {
//            return doGet(node.right, key);
//        } else return node.value;
//    }
}
