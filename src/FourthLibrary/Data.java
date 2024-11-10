package FourthLibrary;

import java.util.LinkedList;
import java.util.Queue;

public class Data {
    private Queue<Falcon> falconQueue; // Очередь для животных

    public Data() {
        falconQueue = new LinkedList<>(); // Инициализация очереди
    }

    // Метод для добавления животного в очередь
    public void addAnimal(Falcon falcon) {
        falconQueue.add(falcon);
    }

    // Метод для получения следующего животного из очереди
    public Falcon getNextAnimal() {
        return falconQueue.poll(); // Получаем и удаляем следующий элемент из очереди
    }

    // Метод для проверки, пуста ли очередь
    public boolean isEmptyData() {
        return falconQueue.isEmpty();
    }

    // Метод для получения размера очереди
    public int size() {
        return falconQueue.size();
    }

    // Метод для вывода всех животных в очереди
    public void printAnimals() {
        if (isEmptyData()) {
            System.out.println("Очередь животных пуста.");
            return;
        }

        System.out.println("Животные в очереди:");
        for (Animal animal : falconQueue) {
            System.out.println(animal); // Выводим каждое животное (предполагается, что есть метод toString())
        }
    }
}
