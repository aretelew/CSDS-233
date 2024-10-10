package assignment3;

import com.sun.source.tree.Tree;

public class BinarySearchTree {
    private TreeNode root;

    public BinarySearchTree() {
        root = null;
    }

    public BinarySearchTree(TreeNode root) {
        this.root = root;
    }

    public TreeNode getRoot() {
        return root;
    }

    public void insert(int key) {
        insert(root, key);
    }

    public TreeNode insert(TreeNode root, int key) {
        if (root == null) {
            return new TreeNode(key);
        }
        if (key == root.key) {
            return root;
        }
        if (key < root.key) {
            root.left = insert(root.left, key);
        } else {
            root.right = insert(root.right, key);
        }
        return root;
    }

    public void createTree(int[] keys) {
        for (int key : keys) {
            insert(key);
        }
    }

    public boolean search(int key) {
        return search(root, key);
    }

    public boolean search(TreeNode root, int key) {
        if (root == null) {
            return false;
        }
        if (key == root.key) {
            return true;
        }
        if (key < root.key) {
            return search(root.left, key);
        }
        return search(root.right, key);
    }

    public void delete(int key) {
        root = delete(root, key);
    }

    public TreeNode delete(TreeNode root, int key) {
        if (root == null) {
            return null;
        }
        if (root.left == null && root.right == null) {
            if (root.key == key) {
                return null;
            }
            return root;
        }

        if (root.left.key == key && root.left.numChildren() == 0) {
            TreeNode removedNode = new TreeNode(root.left.key);
            root.left = null;
            return removedNode;
        } else if (root.right.key == key && root.right.numChildren() == 0) {
            TreeNode removedNode = new TreeNode(root.right.key);
            root.right = null;
            return removedNode;
        }

        if (root.left.key == key && root.left.numChildren() == 1) {
            // NEED TO IMPLEMENT
        } else if (root.right.key == key && root.right.numChildren() == 1) {
            // NEED TO IMPLEMENT
        }

        if (root.left.key == key && root.left.numChildren() == 2) {
            // NEED TO IMPLEMENT
        } else if (root.right.key == key && root.right.numChildren() == 2) {
            // NEED TO IMPLEMENT
        }

        if (key < root.key) {
            root.left = delete(root.left, key);
        } else if (key > root.key) {
            root.right = delete(root.right, key);
        }


    }
}
