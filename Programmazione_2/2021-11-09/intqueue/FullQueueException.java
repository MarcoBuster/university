package intqueue;

public class FullQueueException extends RuntimeException {
    public FullQueueException() {
        super();
    }

    public FullQueueException(String message) {
        super(message);
    }
}
