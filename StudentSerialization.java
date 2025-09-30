import java.io.*;

class Student implements Serializable {
    private static final long serialVersionUID = 1L;

    String studentID;
    String name;
    String grade;

    public Student(String studentID, String name, String grade) {
        this.studentID = studentID;
        this.name = name;
        this.grade = grade;
    }

    @Override
    public String toString() {
        return "StudentID: " + studentID + ", Name: " + name + ", Grade: " + grade;
    }
}

public class StudentSerialization {
    public static void main(String[] args) {
        Student s1 = new Student("11533", "Manthan", "A+");

        // Serialization
        try (FileOutputStream fos = new FileOutputStream("student.ser");
             ObjectOutputStream oos = new ObjectOutputStream(fos)) {
            oos.writeObject(s1);
            System.out.println("Student object serialized successfully!");
        } catch (IOException e) {
            e.printStackTrace();
        }

        try (FileInputStream fis = new FileInputStream("student.ser");
             ObjectInputStream ois = new ObjectInputStream(fis)) {
            Student s2 = (Student) ois.readObject();
            System.out.println("Deserialized Student: " + s2);
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
