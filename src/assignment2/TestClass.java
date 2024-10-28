package assignment2;

public class TestClass {
    public static void main(String[] args) {
        System.out.println("TESTING assignment2.NumLinkedList");
        NumLinkedList list = new NumLinkedList();

        System.out.println("ADDING 1, 2, 3, 4, 5");
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        list.add(5);
        System.out.println("LIST: " + list);
        System.out.println("SIZE: " + list.size());
        System.out.println("IS SORTED: " + list.isSorted());
        System.out.println("REVERSING LIST");
        list.reverse();
        System.out.println("LIST AFTER REVERSE: " + list);
        System.out.println("TESTING DUPLICATE");
        NumLinkedList duplicateList = NumLinkedList.duplicate(list);
        System.out.println("DUPLICATE LIST: " + duplicateList);
        System.out.println("TESTING MERGE");
        NumLinkedList list1 = new NumLinkedList();
        list1.add(1);
        list1.add(3);
        list1.add(5);
        System.out.println("LIST1: " + list1);
        NumLinkedList list2 = new NumLinkedList();
        list2.add(2);
        list2.add(4);
        list2.add(6);
        System.out.println("LIST2: " + list2);
        NumLinkedList mergedList = NumLinkedList.merge(list1, list2);
        System.out.println("MERGED LIST: " + mergedList);

        System.out.println("\n=====================================\n");

        System.out.println("TESTING assignment2.QueuedStack");
        QueuedStack<Integer> stack = new QueuedStack<>();
        System.out.println("PUSHING 1, 2, 3, 4, 5");
        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(4);
        stack.push(5);
        System.out.println("STACK: " + stack);
        System.out.println("PEEKED: " + stack.peek());
        System.out.println("POPPED: " + stack.pop());
        System.out.println("STACK: " + stack);
        System.out.println("IS EMPTY: " + stack.empty());

        System.out.println("\n=====================================\n");

        System.out.println("TESTING assignment2.StackifiedQueue");
        StackifiedQueue<Integer> queue = new StackifiedQueue<>();
        System.out.println("ADDING 1, 2, 3, 4, 5");
        queue.add(1);
        queue.add(2);
        queue.add(3);
        queue.add(4);
        queue.add(5);
        System.out.println("QUEUE:"+ queue);
        System.out.println("POLLED: "+queue.poll());
        System.out.println("QUEUE:"+ queue);
        System.out.println("PEEKED: "+queue.peek());
        System.out.println("QUEUE: "+queue);
        System.out.println("IS EMPTY: "+queue.isEmpty());
    }
}