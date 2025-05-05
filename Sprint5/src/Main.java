import manager.Managers;
import manager.TaskManager;
import model.Task;
import model.Subtask;
import model.Epic;
import model.Status;

public class Main {

    private static void printAllTasks(TaskManager manager) {
        System.out.println("Задачи:");
        for (Task task : manager.getAllTasks()) {
            System.out.println(task);
        }
        System.out.println("Эпики:");
        for (Epic epic : manager.getAllEpics()) {
            System.out.println(epic);

            for (Subtask subtask : manager.getSubtasksByEpic(epic.getId())) {
                System.out.println("--> " + subtask);
            }
        }
        System.out.println("Подзадачи:");
        for (Subtask subtask : manager.getAllSubtasks()) {
            System.out.println(subtask);
        }

        System.out.println("История:");
        for (Task task : manager.getHistory()) {
            System.out.println(task);
        }
    }

    public static void main(String[] args) {
        // Получаем экземпляр менеджера задач
        TaskManager manager = Managers.getDefault();

        // Создаем задачи
        Task task1 = new Task("Задача 1", "Описание задачи 1");
        task1.setStatus(Status.NEW);
        manager.createTask(task1);

        Task task2 = new Task("Задача 2", "Описание задачи 2");
        task2.setStatus(Status.IN_PROGRESS);
        manager.createTask(task2);

        // Создаем эпик
        Epic epic1 = new Epic("Эпик 1", "Описание эпика 1");
        manager.createEpic(epic1);

        // Создаем подзадачи для эпика
        Subtask subtask1 = new Subtask("Подзадача 1", "Описание подзадачи 1", epic1.getId());
        subtask1.setStatus(Status.NEW);
        manager.createSubtask(subtask1);

        Subtask subtask2 = new Subtask("Подзадача 2", "Описание подзадачи 2", epic1.getId());
        subtask2.setStatus(Status.DONE);
        manager.createSubtask(subtask2);

        // Вызов методов для формирования истории
        System.out.println("Получаем задачу 1:");
        manager.getTaskById(task1.getId());

        System.out.println("Получаем эпик 1:");
        manager.getEpicById(epic1.getId());

        System.out.println("Получаем подзадачу 1:");
        manager.getSubtaskById(subtask1.getId());

        // Печать всех задач и истории
        printAllTasks(manager);
    }
}