import java.util.ArrayList;

public class StudentFilterSortSystem {

    static class Student {
        private String studentId;
        private String name;
        private double mark;

        public Student(String studentId, String name, double mark) {
            this.studentId = studentId;
            this.name = name;
            this.mark = mark;
        }

        public String getName() {
            return name;
        }

        public double getMark() {
            return mark;
        }

        public String getGrade() {
            if (mark >= 80) {
                return "A";
            } else if (mark >= 70) {
                return "B";
            } else if (mark >= 60) {
                return "C";
            } else if (mark >= 50) {
                return "D";
            } else {
                return "F";
            }
        }

        public void displayStudent() {
            System.out.println(studentId + " - " + name + " - " + mark + " - Grade " + getGrade());
        }
    }

    public static void main(String[] args) {
        ArrayList<Student> students = new ArrayList<>();

        students.add(new Student("STU1001", "Ravi Kumar", 92.0));
        students.add(new Student("STU1002", "Alex Tan", 88.5));
        students.add(new Student("STU1003", "Mei Ling", 45.0));
        students.add(new Student("STU1004", "Siti Aminah", 76.0));

        System.out.println("All Students");
        System.out.println("------------");
        students.forEach(student -> student.displayStudent());

        System.out.println();
        System.out.println("Passing Students");
        System.out.println("----------------");
        students.stream()
                .filter(student -> student.getMark() >= 50)
                .forEach(student -> student.displayStudent());

        System.out.println();
        System.out.println("Students Sorted by Mark, Highest First");
        System.out.println("--------------------------------------");
        students.sort((s1, s2) -> Double.compare(s2.getMark(), s1.getMark()));
        students.forEach(student -> student.displayStudent());

        System.out.println();
        System.out.println("Students Sorted by Name");
        System.out.println("-----------------------");
        students.sort((s1, s2) -> s1.getName().compareTo(s2.getName()));
        students.forEach(student -> student.displayStudent());
    }
}
