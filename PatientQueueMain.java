import java.util.LinkedList;
import java.util.Queue;

class Patient {
    private int id;
    private String name;

    public Patient(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public void display() {
        System.out.println("Patient [ID: " + id + ", Name: " + name + "]");
    }
}

class ClinicQueue {
    private Queue<Patient> queue = new LinkedList<>();

    public void addPatient(Patient p) {
        queue.offer(p);
        System.out.print("Added to Queue -> ");
        p.display();
    }

    public void servePatient() {
        if (!queue.isEmpty()) {
            Patient served = queue.poll(); // FIFO
            System.out.print("Serving Patient (FIFO) -> ");
            served.display();
        } else {
            System.out.println("No patients in queue to serve.");
        }
    }

    public void displayQueue() {
        System.out.println("
=== Current Patients Waiting in Queue ===");
        if (queue.isEmpty()) {
            System.out.println("Queue is empty.");
            return;
        }
        for (Patient p : queue) {
            p.display();
        }
    }
}

public class PatientQueueMain {
    public static void main(String[] args) {
        ClinicQueue clinic = new ClinicQueue();

        clinic.addPatient(new Patient(1, "Ravi"));
        clinic.addPatient(new Patient(2, "Sunita"));
        clinic.addPatient(new Patient(3, "Deepak"));

        clinic.displayQueue();

        System.out.println("
Serving next patient...");
        clinic.servePatient();

        clinic.displayQueue();
    }
}
