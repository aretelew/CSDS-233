import java.util.LinkedList;
import java.util.Stack;

public class StackifiedQueue<T> {
    private Stack<T> input;
    private Stack<T> output;

    public StackifiedQueue() {
        this.input = new Stack<T>();
        this.output = new Stack<T>();
    }

    public boolean add(T element) {
        input.push(element);
        return true;
    }

    public T poll() {
        if (output.isEmpty() && input.isEmpty()) {
            return null;
        }
        while (!input.isEmpty()) {
            output.push(input.pop());
        }
        return output.pop();
    }

    public T peek() {
        if (input.isEmpty() && output.isEmpty()) {
            return null;
        }
        for (T element : input) {
            output.push(element);
        }
        return output.peek();
    }

    public boolean isEmpty() {
        return input.isEmpty() && output.isEmpty();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (int i = output.size() - 1; i >= 0; i--) {
            sb.append(output.get(i)).append(" <- ");
        }
        for (int i = 0; i < input.size(); i++) {
            sb.append(input.get(i));
            if (i < input.size() - 1) {
                sb.append(" <- ");
            }
        }
        if (sb.length() >= 4 && sb.substring(sb.length() - 4).equals(" <- ")) {
            sb.setLength(sb.length() - 4);
        }
        return sb.toString().isEmpty() ? "Queue is empty" : sb.toString();
    }

}
