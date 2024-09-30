public class TestClass {
    public static void main(String[] args) {
//        QueuedStack<Integer> stack = new QueuedStack<Integer>();
//        stack.push(1);
//        stack.push(2);
//        stack.push(3);
//        stack.push(4);
//        stack.push(5);
//        System.out.println(stack.peek());
//        System.out.println(stack);
//        System.out.println(stack.pop());
//        System.out.println(stack);

        // Make a stackified queue and run some tests
        StackifiedQueue<Integer> queue = new StackifiedQueue<Integer>();
        queue.add(1);
        queue.add(2);
        queue.add(3);
        queue.add(4);
        queue.add(5);
        System.out.println(queue);
        System.out.println("POLLED: "+queue.poll());
        System.out.println(queue.toString());
        System.out.println("PEEKED: "+queue.peek());
        System.out.println("QUEUE: "+queue);

        //Graphical representation of the queue

    }
}