package assignment3;

public class TestClass {
    public static void main(String[] args) {
        System.out.println("TESTING assignment3.BinarySearchTree");
        BinarySearchTree bst = new BinarySearchTree();

        System.out.println("INSERTING 10, 5, 15, 3, 7, 12, 18");
        bst.insert(10);
        bst.insert(5);
        bst.insert(15);
        bst.insert(3);
        bst.insert(7);
        bst.insert(12);
        bst.insert(18);

        System.out.println("=====================================");

        System.out.println("INORDER TRAVERSAL:");
        bst.inorderTrav();

        System.out.println("=====================================");

        System.out.println("PREORDER TRAVERSAL:");
        bst.preorderTrav();

        System.out.println("=====================================");

        System.out.println("POSTORDER TRAVERSAL:");
        bst.postorderTrav();

        System.out.println("=====================================");

        System.out.println("CREATING A NEW TREE WITH 1, 9, 4, 3, 8, 10, 69");
        BinarySearchTree bst2 = new BinarySearchTree();
        bst2.createTree(new int[]{40, 9, 12, 33, 8, 10, 69});

        System.out.print("INORDER TRAVERSAL: ");
        bst2.inorderTrav();

        System.out.println("=====================================");

        System.out.println("SEARCHING FOR 9 (should be true): " + bst2.search(9));
        System.out.println("SEARCHING FOR 12 (should be true): " + bst2.search(12));
        System.out.println("SEARCHING FOR 69 (should be true): " + bst2.search(69));

        System.out.println("=====================================");

        System.out.println("SEARCHING FOR 20 (should be false): " + bst2.search(20));
        System.out.println("SEARCHING FOR 1 (should be false): " + bst2.search(1));
        System.out.println("SEARCHING FOR 15 (should be false): " + bst2.search(15));

        System.out.println("=====================================");

        System.out.println("FINDING MIN (should be 8): " + bst2.findMin());
        System.out.println("FINDING MAX (should be 69): " + bst2.findMax());

        System.out.println("=====================================");

        System.out.println("FINDING HEIGHT (should be 3): " + bst2.height());

        System.out.println("=====================================");
        System.out.println("INORDER TRAVERSAL BEFORE DELETION:");
        bst2.inorderTrav();

        System.out.println("\nDELETING 40");
        bst2.delete(40);
        System.out.println("INORDER TRAVERSAL AFTER DELETION:");
        bst2.inorderTrav();

        System.out.println("=====================================");

        System.out.println("DELETING 12");
        bst2.delete(12);
        System.out.println("INORDER TRAVERSAL AFTER DELETION:");
        bst2.inorderTrav();

        System.out.println("=====================================");

        System.out.println("DELETING 69");
        bst2.delete(69);
        System.out.println("INORDER TRAVERSAL AFTER DELETION:");
        bst2.inorderTrav();
    }
}
