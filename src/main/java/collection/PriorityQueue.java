package collection;

import java.util.LinkedList;

public class PriorityQueue {
    private LinkedList<Task> tasks = new LinkedList<>();

    /**
     * Метод должен вставлять в нужную позицию элемент.
     * Позиция определяется по полю  приоритет.
     * Для вставки использовать add(int index, E value)
     *
     * @param task задача
     */
    public void put(final Task task) {
        int index = 0;
        for (Task element : tasks) {
            if (task.getPriority() <= element.getPriority()) {
                break;
            }
            index++;
        }
        this.tasks.add(index, task);
    }

    /**
     * @return первый элемент списка
     */
    public Task take() {
        return tasks.poll();


    }
}