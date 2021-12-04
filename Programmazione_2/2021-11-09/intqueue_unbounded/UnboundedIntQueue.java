package intqueue_unbounded;

import java.util.LinkedList;
import java.util.List;

public class UnboundedIntQueue {
    public List<Integer> items;

    public UnboundedIntQueue() {
        this.items = new LinkedList<Integer>();
    }

    public void enqueue(Integer n) {
        this.items.add(n);
    }

    public Integer dequeue() {
        Integer item = this.items.get(0);
        this.items.remove(0);
        return item;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (Integer item : this.items) {
            sb.append(String.format("%d ", item));
        }
        return sb.toString();
    }

    public boolean repOK() {
        return this.items.size() > 0;
    }

    public static void main(String[] args) {
        UnboundedIntQueue q = new UnboundedIntQueue();
        q.enqueue(2);
        q.enqueue(3);
        q.enqueue(4);
        q.enqueue(5);
        System.out.println(q.toString());
        System.out.println(String.format("deq: %d %d", q.dequeue(), q.dequeue()));
        System.out.println(q.toString());
        q.enqueue(1);
        System.out.println(q.toString());
        System.out.println(String.format("deq: %d %d %d", q.dequeue(), q.dequeue(), q.dequeue()));
    }
}
