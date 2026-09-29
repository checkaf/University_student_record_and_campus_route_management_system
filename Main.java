import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        // Create data structure objects
        StudentLinkedList studentList = new StudentLinkedList();
        ActionStack actionStack = new ActionStack();
        StudentQueue studentQueue = new StudentQueue();
        StudentBST studentBST = new StudentBST();
        StudentHashTable hashTable = new StudentHashTable(10);
        CampusGraph campusGraph = new CampusGraph();

        // Sample students
        Student student1 = new Student(
                "ST001",
                "Fazal",
                "Bachelor of Information Technology",
                85.0
        );

        Student student2 = new Student(
                "ST002",
                "Ahmed",
                "Computer Science",
                78.0
        );

        Student student3 = new Student(
                "ST003",
                "Kamal",
                "Software Engineering",
                91.0
        );

        // Add sample students to the main data structures
        studentList.addStudent(student1);
        studentList.addStudent(student2);
        studentList.addStudent(student3);

        studentBST.insert(student1);
        studentBST.insert(student2);
        studentBST.insert(student3);

        hashTable.insert(student1);
        hashTable.insert(student2);
        hashTable.insert(student3);

        studentQueue.enqueue(student1);
        studentQueue.enqueue(student2);
        studentQueue.enqueue(student3);

        // Add sample campus routes
        campusGraph.addRoute("Main Hall", "Library");
        campusGraph.addRoute("Main Hall", "Cafeteria");
        campusGraph.addRoute("Library", "Computer Lab");
        campusGraph.addRoute("Cafeteria", "Computer Lab");
        campusGraph.addRoute("Computer Lab", "Lecture Hall");

        // Main menu
        int choice;

        do {

            System.out.println();
            System.out.println("======================================");
            System.out.println("       STUDENT MANAGEMENT SYSTEM");
            System.out.println("======================================");
            System.out.println("1. Display Students");
            System.out.println("2. Search Student");
            System.out.println("3. Add Student");
            System.out.println("4. Update Student");
            System.out.println("5. Delete Student");
            System.out.println("6. Student Queue");
            System.out.println("7. Recent Actions");
            System.out.println("8. BST Operations");
            System.out.println("9. Hash Table");
            System.out.println("10. Campus Graph");
            System.out.println("0. Exit");
            System.out.println("======================================");

            System.out.print("Enter your choice: ");

            choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {

                case 1:
                    System.out.println();
                    System.out.println("===== ALL STUDENTS =====");
                    studentList.displayAllStudents();
                    break;

                case 2:
                    System.out.print("Enter Student ID: ");
                    String searchId = scanner.nextLine();

                    Student foundStudent =
                            studentList.searchStudent(searchId);

                    if (foundStudent != null) {
                        System.out.println();
                        System.out.println("Student found:");
                        foundStudent.displayStudent();
                    } else {
                        System.out.println("Student not found.");
                    }
                    break;

                case 3:
                    System.out.print("Enter Student ID: ");
                    String id = scanner.nextLine();

                    System.out.print("Enter Name: ");
                    String name = scanner.nextLine();

                    System.out.print("Enter Programme: ");
                    String programme = scanner.nextLine();

                    System.out.print("Enter Marks: ");
                    double marks = scanner.nextDouble();
                    scanner.nextLine();

                    Student newStudent =
                            new Student(id, name, programme, marks);

                    if (studentList.addStudent(newStudent)) {

                        studentBST.insert(newStudent);
                        hashTable.insert(newStudent);
                        studentQueue.enqueue(newStudent);

                        actionStack.push(
                                "Added student " + id
                        );

                        System.out.println(
                                "Student added successfully."
                        );

                    } else {
                        System.out.println(
                                "Student ID already exists."
                        );
                    }
                    break;

                case 4:
                    System.out.print("Enter Student ID to update: ");
                    String updateId = scanner.nextLine();

                    System.out.print("Enter New Name: ");
                    String newName = scanner.nextLine();

                    System.out.print("Enter New Programme: ");
                    String newProgramme = scanner.nextLine();

                    System.out.print("Enter New Marks: ");
                    double newMarks = scanner.nextDouble();
                    scanner.nextLine();

                    if (studentList.updateStudent(
                            updateId,
                            newName,
                            newProgramme,
                            newMarks)) {

                        actionStack.push(
                                "Updated student " + updateId
                        );

                        System.out.println(
                                "Student updated successfully."
                        );

                    } else {
                        System.out.println(
                                "Student not found."
                        );
                    }
                    break;

                case 5:
                    System.out.print("Enter Student ID to delete: ");
                    String deleteId = scanner.nextLine();

                    if (studentList.deleteStudent(deleteId)) {

                        studentBST.delete(deleteId);
                        hashTable.delete(deleteId);
                        studentQueue.delete(deleteId);

                        actionStack.push(
                                "Deleted student " + deleteId
                        );

                        System.out.println(
                                "Student deleted successfully."
                        );

                    } else {
                        System.out.println(
                                "Student not found."
                        );
                    }
                    break;

                case 6:
                    System.out.println();
                    studentQueue.displayQueue();

                    System.out.println();
                    Student frontStudent = studentQueue.peek();

                    if (frontStudent != null) {
                        System.out.println("===== FRONT STUDENT =====");
                        frontStudent.displayStudent();
                    } else {
                        System.out.println("Queue is empty.");
                    }
                    break;

                case 7:
                    System.out.println();
                    actionStack.displayActions();
                    break;

                case 8:
                    System.out.println();
                    studentBST.displayInOrder();

                    System.out.println();
                    System.out.print("Enter Student ID to search in BST: ");
                    String bstId = scanner.nextLine();

                    Student bstStudent = studentBST.search(bstId);

                    if (bstStudent != null) {
                        System.out.println("Student found in BST:");
                        bstStudent.displayStudent();
                    } else {
                        System.out.println("Student not found in BST.");
                    }
                    break;

                case 9:
                    System.out.println();
                    hashTable.displayTable();

                    System.out.println();
                    System.out.print("Enter Student ID to search: ");
                    String hashId = scanner.nextLine();

                    Student hashStudent = hashTable.search(hashId);

                    if (hashStudent != null) {
                        System.out.println("Student found:");
                        hashStudent.displayStudent();
                    } else {
                        System.out.println("Student not found.");
                    }
                    break;

                case 10:
                    System.out.println();
                    campusGraph.displayGraph();

                    System.out.println();
                    campusGraph.BFS("Main Hall");

                    System.out.println();
                    campusGraph.DFS("Main Hall");
                    break;

                case 11:
                    System.out.println();
                    System.out.println(
                            "Exiting Student Management System..."
                    );
                    break;

                default:
                    System.out.println(
                            "Invalid choice. Please try again."
                    );
            }

        } while (choice != 11);

        scanner.close();
    }
}