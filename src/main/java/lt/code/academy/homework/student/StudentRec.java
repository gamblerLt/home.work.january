package lt.code.academy.homework.student;

public class StudentRec {
    String studentNumber;
    String studentName;
    String studentSurname;

    public StudentRec(String studentNumber, String studentName, String studentSurname) {
        this.studentNumber = studentNumber;
        this.studentName = studentName;
        this.studentSurname = studentSurname;
    }

    public String getStudentNumber() {
        return studentNumber;
    }

    public void setStudendtNumber(String studendtNumber) {
        this.studentNumber = studendtNumber;
    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public String getStudentSurname() {
        return studentSurname;
    }

    public void setStudentSurname(String studentSurname) {
        this.studentSurname = studentSurname;
    }

    @Override
    public String toString() {
        return "Studentas{" +
                "Numeris='" + studentNumber + '\'' +
                ", Vardas='" + studentName + '\'' +
                ", Pavarde='" + studentSurname + '\'' +
                '}';
    }
}
