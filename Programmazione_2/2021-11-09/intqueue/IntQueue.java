package intqueue;

public class IntQueue {
    private final int size;
    private int[] items;
    private int first;
    private int last;
    private int count;

    /**
     * Crea una nuova IntQueue con lunghezza massima n
     * 
     * @param n lunghezza massima della coda, deve essere positivo
     */
    public IntQueue(int n) {
        this.size = n;
        this.items = new int[this.size+1];
        this.first = 1;
        this.last = 0;
        this.count = 0;
    }

    /**
     * Metti in coda un elemento
     * 
     * @param n l'intero da mettere in coda
     * @throws FullQueueException se la coda è piena
     */
    public void enqueue(int n) throws FullQueueException {
        if (this.isFull()) {
            throw new FullQueueException();
        }
        if (++this.last >= this.size+1) {
            this.last = 1;
        }
        this.items[this.last] = n;
        this.count++;
    }

    /**
     * Rimuovi dalla coda un elemento
     * 
     * @return l'elemento rimosso
     * @throws EmptyQueueException se la coda è vuota
     */
    public int dequeue() throws EmptyQueueException {
        if (this.isEmpty()) {
            throw new EmptyQueueException();
        }
        if (this.first == size+1) {
            this.first = 1;
        }
        this.count--;
        return this.items[this.first++];
    }

    /**
     * @return if the queue is full
     */
    public boolean isFull() {
        return this.count == this.size;
    }

    /**
     * @return if the queue is empty
     */
    public boolean isEmpty() {
        return this.first - this.last == 1;
    }

    @Override
    public String toString() {
        if (this.isEmpty()) {
            return "<empty>";
        }

        StringBuilder sb = new StringBuilder();
        for (int i = this.first; i-1 != this.last; i++) {
            if (i == this.size+1) {
                i = 1;
            }
            sb.append(String.format("%d ", this.items[i]));
        }
        return sb.toString();
    }

    public boolean repOK() {
        return this.first != this.last;
    }

    public static void main(String[] args) {
        IntQueue q = new IntQueue(4);
        q.enqueue(3);
        q.enqueue(2);
        q.enqueue(4);
        q.enqueue(5);
        // q.enqueue(6);
        // q.enqueue(7);
        System.out.println(q.toString());
        System.out.println(String.format("deq: %d %d", q.dequeue(), q.dequeue()));
        System.out.println(q.toString());
        q.enqueue(1);
        System.out.println(q.toString());
        System.out.println(String.format("deq: %d %d %d", q.dequeue(), q.dequeue(), q.dequeue()));
        System.out.println(q.toString());
    }
}
