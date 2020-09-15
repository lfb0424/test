package tree;

/**
 * Binary Search Tree 二叉搜索树
 *
 * @author: LFb
 * @date: 2020/9/11 13:55
 */
public class BSNodeTest<T extends Comparable<T>> {
    //根节点
    private BSTNode<T> mRoot;

    public class BSTNode<T extends Comparable<T>> {
        /**
         * 关键字(键值)
         */
        T key;
        BSTNode<T> left;
        BSTNode<T> right;
        BSTNode<T> parent;

        public BSTNode(T key, BSTNode<T> parent, BSTNode<T> left, BSTNode<T> right) {
            this.key = key;
            this.parent = parent;
            this.left = left;
            this.right = right;
        }
    }

    /**
     * 前序遍历
     *
     * @param tree
     */
    private void preOrder(BSTNode<T> tree) {
        if (tree != null) {
            System.out.println(tree.key + " ");
            preOrder(tree.left);
            preOrder(tree.right);
        }
    }

    /**
     * 中序遍历
     */
    private void inOrder(BSTNode<T> tree) {
        if (tree != null) {
            inOrder(tree.left);
            System.out.println(tree.key + "");
            inOrder(tree.right);
        }
    }

    /**
     * 后序遍历
     */
    private void postOrder(BSTNode<T> tree) {
        postOrder(tree.left);
        postOrder(tree.right);
        System.out.println(tree.key + "");
    }

    /**
     * (递归实现)查找“二叉树x” 中键值为key的节点
     */
    private BSTNode<T> search(BSTNode<T> x, T key) {
        if (x == null) {
            return x;
        }
        int tmp = key.compareTo(x.key);
        if (tmp < 0) {
            return search(x.left, key);
        } else if (tmp > 0) {
            return search(x.right, key);
        } else {
            return x;
        }
    }

    public BSTNode<T> search(T key) {
        return search(mRoot, key);
    }

    /**
     * (非递归实现)查找“二叉树x” 中键值为key的节点
     */
    private BSTNode<T> iterativeSearch(BSTNode<T> x, T key) {
        while (x != null) {
            int tmp = key.compareTo(x.key);
            if (tmp < 0) {
                x = x.left;
            } else if (tmp > 0) {
                x = x.right;
            } else {
                return x;
            }
        }
        return x;
    }

    public BSTNode<T> iterativeSearch(T key) {
        return iterativeSearch(mRoot, key);
    }
}
