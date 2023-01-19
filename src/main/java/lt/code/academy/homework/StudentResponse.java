package lt.code.academy.homework;

public class StudentResponse {

    private int response;

    public StudentResponse(int response) {
        this.response = response;
    }

    public int getResponse() {
        return response;
    }

    public void setResponse(int response) {
        this.response = response;
    }

    @Override
    public String toString() {
        return "StudentResponse{" +
                "response=" + response +
                '}';
    }
}