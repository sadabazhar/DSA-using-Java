public class QueueDS {

    protected int front;
    protected int rear;
    protected int size;
    protected int[] queue;

    QueueDS() {
        this(10);
    }

    QueueDS(int size) {
        this.size = size;
        this.queue = new int[size];
        this.front = -1;
        this.rear = -1;
    }

    public void enQueue(int data) {
        if (isFull()) {
            System.err.println("Queue is full!");
            return;
        }

        rear++;
        queue[rear] = data;

        //for first element
        if(front == -1) front = 0;
    }

    public void deQueue() {
        if (isEmpty()) {
            System.err.println("Queue is empty!");
            return;
        }

        front++;

        // Reset if last element is removed
        if (front > rear) {
            front = -1;
            rear = -1;
        }
    }

    public boolean isFull() {
        return rear == size - 1;
    }

    public boolean isEmpty() {
        return rear == -1;
    }

    public int getFront() {
        if (isEmpty()) {
            throw new IllegalStateException("Queue is empty!");
        }
        return queue[front];
    }

    public int getSize() {
        return isEmpty() ? 0 : (rear - front + 1);
    }

    public void print() {
        if (isEmpty()) {
            System.err.println("Queue is empty!");
            return;
        }

        for (int i = front; i <= rear; i++) {
            System.out.println(queue[i]);
        }
    }

    @Override
    public String toString() {
        if (isEmpty()) return "[]";

        StringBuilder sb = new StringBuilder("[");
        for (int i = front; i <= rear; i++) {
            sb.append(queue[i]);
            if (i < rear) sb.append(", ");
        }
        sb.append("]");
        return sb.toString();
    }

    public static void main(String[] args) {
        QueueDS queue = new QueueDS(5);

        queue.enQueue(10);
        queue.enQueue(20);
        queue.enQueue(30);
        queue.enQueue(40);
        queue.enQueue(50);
        queue.enQueue(60); // Should print "Queue is full!"

        queue.print();

        System.out.println("After deletion:");
        
        queue.deQueue();
        queue.deQueue();
        queue.deQueue();
        queue.deQueue();
        queue.print();

        System.out.println("After Adding:");
        queue.enQueue(20);
        queue.enQueue(30);
        queue.enQueue(40);
        queue.enQueue(50);

        queue.print();
    }
}
