public class StudentHashTable {

    private Student[] table;
    private int size;

    public StudentHashTable(int size) {
        this.size = size;
        table = new Student[size];
    }

    // Hash function
    private int hash(String studentId) {

        int hashValue = 0;

        for (int i = 0; i < studentId.length(); i++) {
            hashValue = hashValue + studentId.charAt(i);
        }

        return hashValue % size;
    }

    // Add student
    public boolean insert(Student student) {

        int index = hash(student.getStudentId());

        // Linear probing for collision handling
        for (int i = 0; i < size; i++) {

            int newIndex = (index + i) % size;

            if (table[newIndex] == null) {
                table[newIndex] = student;
                return true;
            }

            // Duplicate ID
            if (table[newIndex].getStudentId()
                    .equalsIgnoreCase(student.getStudentId())) {
                return false;
            }
        }

        return false;
    }

    // Search student
    public Student search(String studentId) {

        int index = hash(studentId);

        for (int i = 0; i < size; i++) {

            int newIndex = (index + i) % size;

            if (table[newIndex] == null) {
                return null;
            }

            if (table[newIndex].getStudentId()
                    .equalsIgnoreCase(studentId)) {
                return table[newIndex];
            }
        }

        return null;
    }

    // Display hash table
    public void displayTable() {

        System.out.println("===== HASH TABLE =====");

        for (int i = 0; i < size; i++) {

            System.out.print("Index " + i + ": ");

            if (table[i] == null) {
                System.out.println("Empty");
            } else {
                System.out.println(
                        table[i].getStudentId()
                        + " - "
                        + table[i].getName()
                );
            }
        }
    }
    // Delete student
public boolean delete(String studentId) {

    int index = hash(studentId);

    for (int i = 0; i < size; i++) {

        int newIndex = (index + i) % size;

        if (table[newIndex] == null) {
            return false;
        }

        if (table[newIndex].getStudentId()
                .equalsIgnoreCase(studentId)) {

            table[newIndex] = null;
            return true;
        }
    }

    return false;
}
}