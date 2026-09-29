public class StudentQueue {

    // Node class
    private class Node {
        Student student;
        Node next;

        Node(Student student) {
            this.student = student;
            this.next = null;
        }
    }

    private Node front;
    private Node rear;

    // Add student to the queue
    public void enqueue(Student student) {

        Node newNode = new Node(student);

        // If queue is empty
        if (rear == null) {
            front = newNode;
            rear = newNode;
            return;
        }

        // Add new node at the rear
        rear.next = newNode;
        rear = newNode;
    }

    // Remove student from the queue
    public Student dequeue() {

        // If queue is empty
        if (front == null) {
            return null;
        }

        Student student = front.student;

        // Move front to the next node
        front = front.next;

        // If queue becomes empty
        if (front == null) {
            rear = null;
        }

        return student;
    }

    // View the first student
    public Student peek() {

        if (front == null) {
            return null;
        }

        return front.student;
    }

    // Check whether queue is empty
    public boolean isEmpty() {
        return front == null;
    }

    // Display all students in queue
    public void displayQueue() {

        if (front == null) {
            System.out.println("Queue is empty.");
            return;
        }

        Node current = front;

        System.out.println("===== STUDENT QUEUE =====");

        while (current != null) {

            current.student.displayStudent();

            current = current.next;
        }
    }
    // Delete student from queue
public boolean delete(String studentId) {

    if (front == null) {
        return false;
    }

    // If the student is at the front
    if (front.student.getStudentId()
            .equalsIgnoreCase(studentId)) {

        front = front.next;

        if (front == null) {
            rear = null;
        }

        return true;
    }

    Node current = front;

    while (current.next != null) {

        if (current.next.student.getStudentId()
                .equalsIgnoreCase(studentId)) {

            // Remove the student
            current.next = current.next.next;

            // Update rear if necessary
            if (current.next == null) {
                rear = current;
            }

            return true;
        }

        current = current.next;
    }

    return false;
}
}