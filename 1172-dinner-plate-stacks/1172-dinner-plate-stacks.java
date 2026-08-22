import java.util.*;

class DinnerPlates {
    private List<Stack<Integer>> dinnerPlates;
    private PriorityQueue<Integer> ind;
    private int capacity;

    public DinnerPlates(int capacity) {
        this.capacity = capacity;
        this.dinnerPlates = new ArrayList<>();
        this.ind = new PriorityQueue<>();
    }

    public void push(int val) {
        while (!ind.isEmpty() && (ind.peek() >= dinnerPlates.size() || dinnerPlates.get(ind.peek()).size() == capacity)) {
            ind.poll();
        }
        if (!ind.isEmpty()) {
            int i = ind.peek();
            dinnerPlates.get(i).push(val);
            if (dinnerPlates.get(i).size() == capacity) {
                ind.poll();
            }
        } else {
            if (!dinnerPlates.isEmpty() && dinnerPlates.get(dinnerPlates.size() - 1).size() < capacity) {
                dinnerPlates.get(dinnerPlates.size() - 1).push(val);
            } else {
                Stack<Integer> newStack = new Stack<>();
                newStack.push(val);
                dinnerPlates.add(newStack);
            }
        }
    }

    public int pop() {
        while (!dinnerPlates.isEmpty() && dinnerPlates.get(dinnerPlates.size() - 1).isEmpty()) {
            dinnerPlates.remove(dinnerPlates.size() - 1);
        }
        if (dinnerPlates.isEmpty()) {
            return -1;
        }
        return popAtStack(dinnerPlates.size() - 1);
    }

    public int popAtStack(int index) {
        if (index < 0 || index >= dinnerPlates.size() || dinnerPlates.get(index).isEmpty()) {
            return -1;
        }
        Stack<Integer> stack = dinnerPlates.get(index);
        int value = stack.pop();
        ind.add(index);
        return value;
    }
}