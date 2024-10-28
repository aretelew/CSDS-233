package assignment3;

public class BinarySearchTree {
    private TreeNode root;

    public BinarySearchTree() {
        root = null;
    }

    public BinarySearchTree(TreeNode root) {
        this.root = root;
    }

    // Gets the root node
    public TreeNode getRoot() {
        return root;
    }

    // Inserts a key into the tree
    public void insert(int key) {
        root = insert(root, key);
    }

    // Recursive helper method to insert a key into the tree
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

    // Inserts an array of keys into the tree
    public void createTree(int[] keys) {
        for (int key : keys) {
            insert(key);
        }
    }

    // Searches for a key in the tree
    public boolean search(int key) {
        return search(root, key);
    }

    // Recursive helper method to search for a key in the tree
    public boolean search(TreeNode root, int key) {
        if (root == null) {
            return false;
        }
        if (key == root.key) {
            return true;
        }
        // If the key is less than the root's key, it is in the left subtree
        if (key < root.key) {
            return search(root.left, key);
        }
        return search(root.right, key);
    }

    // Deletes a key from the tree
    public void delete(int key) {
        root = delete(root, key);
    }

    // Recursive helper method to delete a key from the tree
    public TreeNode delete(TreeNode root, int key) {
        if (root == null) {
            return null;
        }
        // If the key is less than the root's key, it is in the left subtree
        if (key < root.key) {
            root.left = delete(root.left, key);
        // If the key is greater than the root's key, it is in the right subtree
        } else if (key > root.key) {
            root.right = delete(root.right, key);
        // If the key is equal to the root's key, it is the node to be deleted
        } else {
            // If node with only one child or no child
            if (root.left == null) {
                return root.right;
            } else if (root.right == null) {
                return root.left;
            }
            // If node with two children then get the inorder successor (smallest in the right subtree)
            root.key = findMin(root.right).key;
            root.right = delete(root.right, root.key);
        }
        return root;
    }

    // Gets the height of the tree
    public int height() {
        return height(root);
    }

    // Recursive helper method to get the height of the tree
    public int height(TreeNode root) {
        if (root == null) {
            return -1;
        }
        return 1 + Math.max(height(root.left), height(root.right));
    }

    // Finds the minimum key in the tree
    public int findMin() {
        return findMin(root).key;
    }

    // Recursive helper method to find the minimum key in the tree
    public TreeNode findMin(TreeNode root) {
        if (root.left == null) {
            return root;
        }
        return findMin(root.left);
    }

    // Finds the maximum key in the tree
    public int findMax() {
        return findMax(root).key;
    }

    // Recursive helper method to find the maximum key in the tree
    public TreeNode findMax(TreeNode root) {
        if (root.right == null) {
            return root;
        }
        return findMax(root.right);
    }

    // Traverses the tree in order
    public void inorderTrav() {
        inorderTrav(root);
    }

    // Recursive helper method to traverse the tree in order
    public void inorderTrav(TreeNode root) {
        if (root == null) {
            return;
        }
        inorderTrav(root.left);
        System.out.print(root.key + " ");
        inorderTrav(root.right);
        if (root == this.root) {
            System.out.println();
        }
    }

    // Traverses the tree in pre-order
    public void preorderTrav() {
        preorderTrav(root);
    }

    // Recursive helper method to traverse the tree in pre-order
    public void preorderTrav(TreeNode root) {
        if (root == null) {
            return;
        }
        System.out.print(root.key + " ");
        preorderTrav(root.left);
        preorderTrav(root.right);
        if (root == this.root) {
            System.out.println();
        }
    }

    // Traverses the tree in post-order
    public void postorderTrav() {
        postorderTrav(root);
    }

    // Recursive helper method to traverse the tree in post-order
    public void postorderTrav(TreeNode root) {
        if (root == null) {
            return;
        }
        postorderTrav(root.left);
        postorderTrav(root.right);
        System.out.print(root.key + " ");
        if (root == this.root) {
            System.out.println();
        }
    }
}