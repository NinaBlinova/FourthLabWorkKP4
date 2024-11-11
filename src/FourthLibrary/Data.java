package FourthLibrary;

import java.util.LinkedList;
import java.util.Queue;

public class Data {
    private Queue<Animal> animalQueue; // Очередь для животных

    public Data() {
        animalQueue = new LinkedList<>(); // Инициализация очереди
    }

    // Метод для добавления животного в очередь
    public void addAnimal(Animal animal) {
        animalQueue.add(animal);
    }

    // Метод для получения следующего животного из очереди
    public Animal getNextAnimal() {
        return animalQueue.poll(); // Получаем и удаляем следующий элемент из очереди
    }

    // Метод для проверки, пуста ли очередь
    public boolean isEmptyData() {
        return animalQueue.isEmpty();
    }

    // Метод для получения размера очереди
    public int size() {
        return animalQueue.size();
    }

    // Метод для вывода всех животных в очереди
    public void printAnimals() {
        if (isEmptyData()) {
            System.out.println("Очередь животных пуста.");
            return;
        }

        System.out.println("Животные в очереди:");
        for (Animal animal : animalQueue) {
            System.out.println(animal); // Выводим каждое животное (предполагается, что есть метод toString())
        }
    }
}
