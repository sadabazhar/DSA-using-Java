/*
 * Circular Q - It eliminate the limitation of linear Q
 */

public class CircularQ {
    protected int front;
    protected int rear;
    protected int size;
    protected int[] queue;

    CircularQ() {
        this(10);
    }

    CircularQ(int size) {
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

        if (isEmpty()) {    //For first element
            front = rear = 0;
        } else {
            rear = (rear + 1) % size;
        }

        queue[rear] = data;
    }

    public void deQueue() {
        if (isEmpty()) {
            System.err.println("Queue is empty!");
            return;
        }

        if (front == rear) {    //For last element
            front = rear = -1;
        } else {
            front = (front + 1) % size;
        }
    }

    public boolean isFull() {
        return ((rear + 1) % size) == front;
    }

    public boolean isEmpty() {
        return front == -1;
    }

    public int getFront() {
        if (isEmpty()) {
            throw new IllegalStateException("Queue is empty!");
        }
        return queue[front];
    }

    public int getSize() {
        if (isEmpty()) return 0;
        if (rear >= front) return rear - front + 1;
        return size - front + rear + 1;
    }

    public void print() {
        if (isEmpty()) {
            System.err.println("Queue is empty!");
            return;
        }

        System.out.print("Queue: ");
        int i = front;
        while (true) {
            System.out.print(queue[i] + " ");
            if (i == rear) break;
            i = (i + 1) % size;
        }
        System.out.println();
    }

    @Override
    public String toString() {
        if (isEmpty()) return "[]";
        StringBuilder sb = new StringBuilder("[");
        int i = front;
        while (true) {
            sb.append(queue[i]);
            if (i == rear) break;
            sb.append(", ");
            i = (i + 1) % size;
        }
        sb.append("]");
        return sb.toString();
    }

    public static void main(String[] args) {
        CircularQ queue = new CircularQ(5);

        queue.enQueue(10);
        queue.enQueue(20);
        queue.enQueue(30);
        queue.enQueue(40);
        queue.enQueue(50);
        queue.enQueue(60);

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
