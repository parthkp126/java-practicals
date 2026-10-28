import java.io.*;

public class SaveLoadDemo {
    static class Student implements Serializable {
        private static final long serialVersionUID = 1L;

        private String name;
        private int age;
        private transient String password;

        Student(String name, int age, String password) {
            this.name = name;
            this.age = age;
            this.password = password;
        }

        @Override
        public String toString() {
            return name + ", age " + age + ", password " + password;
        }
    }

    public static void main(String[] args) {
        Student[] students = {
            new Student("Riya", 20, "secret1"),
            new Student("Aman", 21, "secret2")
        };

        try (ObjectOutputStream output =
                     new ObjectOutputStream(
                             new FileOutputStream("students.dat"))) {
            output.writeObject(students);
            System.out.println("Students saved.");
        } catch (IOException exception) {
            System.out.println("Save error: " + exception.getMessage());
        }

        try (ObjectInputStream input =
                     new ObjectInputStream(
                             new FileInputStream("students.dat"))) {
            Student[] loaded = (Student[]) input.readObject();

            for (Student student : loaded) {
                System.out.println(student);
            }
        } catch (IOException | ClassNotFoundException exception) {
            System.out.println("Load error: " + exception.getMessage());
        }
    }
}