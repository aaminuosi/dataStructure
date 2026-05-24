package D2;

public class BSTree {
    BSTNode root;

    static class BSTNode {
        int key;
        Object value;
        BSTNode left;
        BSTNode right;//

        public BSTNode(int key) {
            this.key = key;
        }

        public BSTNode(int key, Object value) {
            this.key = key;
            this.value = value;
        }

        public BSTNode(int key, Object value, BSTNode left, BSTNode right) {
            this.key = key;
            this.value = value;
            this.left = left;
            this.right = right;
        }
    }

    public Object getE(int key) {
        BSTNode node = root;
        while (node != null) {
            if (key < node.key) {
                node = node.left;
            } else if (node.key < key) {
                node = node.right;
            } else {
                return node.value;
            }
        }
        return null;
    }

    public Object get(int key) {
        return doGet(root, key);
    }

    private Object doGet(BSTNode node, int key) {
        if (node == null) {
            return null;
        }
        if (key < node.key) {
            return doGet(node.left, key);
        } else if (node.key < key) {
            return doGet(node.right, key);
        } else return node.value;
    }

    public Object minE() {
        if (root == null) {
            return null;
        }
        BSTNode p = root;
        while (p.left != null) {
            p = p.left;
        }
        return p.value;
    }

    public Object min() {
        return doMin(root);
    }

    private Object doMin(BSTNode node) {
        if (node == null) {
            return null;
        }
        if (node.left == null) {
            return node.value;
        }
        return doMin(node.left);
    }

    public void put(int key, Object value) {
        BSTNode node = root;
        BSTNode parent = null;
        while (node != null) {
            parent = node;
            if (key < node.key) {
                node = node.left;
            } else if (node.key > key) {
                node = node.right;
            } else {
                node.value = value;
                return;
            }
        }
        if (parent == null) {
            root = new BSTNode(key, value);
            return;
        }
        if (key < parent.key) {
            parent.left = new BSTNode(key, value);
        } else if (key > parent.key) {
            parent.right = new BSTNode(key, value);
        }
    }
}
