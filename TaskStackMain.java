import java.util.Stack;

class Task {
    private int taskId;
    private String description;

    public Task(int taskId, String description) {
        this.taskId = taskId;
        this.description = description;
    }

    public void displayTask() {
        System.out.println("Task #" + taskId + ": " + description);
    }
}

class TaskManager {
    private Stack<Task> taskStack = new Stack<>();

    public void pushTask(Task task) {
        taskStack.push(task);
        System.out.print("Pushed Task -> ");
        task.displayTask();
    }

    public void popTask() {
        if (!taskStack.isEmpty()) {
            Task completed = taskStack.pop();
            System.out.print("Popped Completed Task -> ");
            completed.displayTask();
        } else {
            System.out.println("Stack is empty! No task to pop.");
        }
    }

    public void displayRemainingTasks() {
        System.out.println("
=== Remaining Tasks in Stack (Top to Bottom) ===");
        if (taskStack.isEmpty()) {
            System.out.println("No tasks remaining.");
            return;
        }
        for (int i = taskStack.size() - 1; i >= 0; i--) {
            taskStack.get(i).displayTask();
        }
    }
}

public class TaskStackMain {
    public static void main(String[] args) {
        TaskManager manager = new TaskManager();

        manager.pushTask(new Task(101, "Compile Java Code"));
        manager.pushTask(new Task(102, "Run Unit Tests"));
        manager.pushTask(new Task(103, "Generate Reports"));

        manager.displayRemainingTasks();

        System.out.println("
Performing pop operation...");
        manager.popTask();

        manager.displayRemainingTasks();
    }
}
