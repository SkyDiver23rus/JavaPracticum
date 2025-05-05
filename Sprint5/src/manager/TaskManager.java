package manager;

import model.Task;
import model.Subtask;
import model.Epic;

import java.util.List;

public interface TaskManager {
    Task createTask(Task task);
    void createSubtask(Subtask subtask);
    void createEpic(Epic epic);
    Task getTaskById(int id);
    void getSubtaskById(int id);
    void getEpicById(int id);
    List<Task> getAllTasks();
    List<Subtask> getAllSubtasks();
    List<Epic> getAllEpics();
    void removeTask(int id);
    void removeSubtask(int id);
    void removeEpic(int id);
    void removeAllTasks();
    void removeAllSubTasks();
    void removeAllEpic();
    List<Task> getHistory();

    List<Subtask> getSubtasksByEpic(int epicId);
}