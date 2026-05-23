package D2;

public class TreeTraversal {
//    static void main(String[] args) {
//        TreeNode root = new TreeNode(new TreeNode(4), 2, null),
//        1,
//        new TreeNode(new TreeNode(5), 3, new TreeNode(6))
//        );
//    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(
                new TreeNode(new TreeNode(4), 2, null),   // 节点2，左孩子4，右孩子空
                1,                                         // 根
                new TreeNode(new TreeNode(5), 3, new TreeNode(6)) // 节点3，左5右6
        );
        

        TreeNode curr = root;
        while (curr != null) {
            System.out.println(curr.val);
            curr = curr.left;
        }
    }

    static void preOder(TreeNode node) {
        if (node == null) {
            return;
        }
        System.out.println(node.val + "\t");
        preOder(node.left);
        preOder(node.right);
    }

}
