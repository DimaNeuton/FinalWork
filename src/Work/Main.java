package Work;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import static Work.Animal.*;

public class Main {
    public static void main(String[] args) throws IOException {
        // Создаем путь к файлу с животными
        String filePath = "D:\\GeekBrains\\1 четверть\\18. Итоговая работа\\FinalWork\\FinalWork\\src\\Work\\" +
                "Animals.txt";

        // Создаем объект файл
        File animals = new File(filePath);

        // Создаем считыватель потока из файла
        Scanner animalScan = new Scanner(animals);

        // Создаем список из задач
        ArrayList<Animal> animalList;
        animalList = animalListCreator(animalScan);

        boolean flag = true;
        while (flag) {
            Menu();
            Scanner input = new Scanner(System.in);
            int command = input.nextInt();
            switch (command) {
                case 1 -> addAnimal(animalList);                // Завести животное
                case 2 -> teachAnimal(animalList);              // Научить животное новой команде
                case 3 -> showAnimals(animalList);              // Вывести список животных с информацией о них
                case 4 -> saveChanges(animalList, animals);     // Сохранить изменения
                case 5 -> flag = false;                         // Выйти
            }
        }
    }
}
// Добавить в метод animalListCreator определение класса животного
// Добавить определение класса через getClass
// Загрузить программу и файлы на GitHub