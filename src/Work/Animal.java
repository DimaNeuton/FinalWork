package Work;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class Animal {
    private String name;
    private String birthDate;
    private ArrayList<String> commands = new ArrayList<>();
    private String type;

    public Animal(String name, String birthDate, String type) {
        this.name = name;
        this.birthDate = birthDate;
        this.type = type;
    }

    public Animal(String name, String birthDate, String type, ArrayList<String> commands) {
        this.name = name;
        this.birthDate = birthDate;
        this.type = type;
        this.commands = commands;
    }

    public String getName() {
        return name;
    }

    public String getBirthDate() {
        return birthDate;
    }

    public String getType() {
        return type;
    }

    public String getCommands() {
        return commands.toString();
    }

    private String getCommandsT() {
        StringBuilder sb = new StringBuilder();
        for (String command : commands) {
            sb.append(command + "_");
        }
        return sb.toString();
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setBirthDate(String birthDate) {
        this.birthDate = birthDate;
    }

    public void setCommands(String command) {
        this.commands.add(command);
    }

    /**
     * Метод, который считывает из файла данные и преобразует их в список объектов
     * класса Cat, Dog или Hamster
     * @param scan - поток из файла с животными
     * @return
     */
    public static ArrayList<Animal> animalListCreator(Scanner scan) {
        // создаем пустой список для заполнения его объектами класса Animal
        ArrayList<Animal> animalList = new ArrayList<>();
        // считываем посторчно данныеиз файла
        while (scan.hasNextLine()) {
            // преобразуем каждую строку в строковый массив
            String[] arrLine = scan.nextLine().split("-");
            // создаем пустой список для заполнения его командами
            ArrayList<String> commandStr = new ArrayList<>();
            // если команда в строке существует:
            if (arrLine.length > 3) {
                // для каждой команды
                for (String command : arrLine[3].split("_")) {
                    // добавляем команду в список
                    commandStr.add(command);
                }
                // создаем соответствующий объект, исходя из вида животного
                switch (arrLine[2]) {
                    case "cat" -> {
                        Cat animal = new Cat(arrLine[0], arrLine[1], arrLine[2], commandStr);
                    }
                    case "dog" -> {
                        Dog animal = new Dog(arrLine[0], arrLine[1], arrLine[2], commandStr);
                    }
                    case "hamster" -> {
                        Hamster animal = new Hamster(arrLine[0], arrLine[1], arrLine[2], commandStr);
                    }
                }
            }
            // если команды в строке отсутствуют также определяем тип животного
            else {
                switch (arrLine[2]) {
                    case "cat" -> {
                        Cat animal = new Cat(arrLine[0], arrLine[1], arrLine[2]);
                    }
                    case "dog" -> {
                        Dog animal = new Dog(arrLine[0], arrLine[1], arrLine[2]);
                    }
                    case "hamster" -> {
                        Hamster animal = new Hamster(arrLine[0], arrLine[1], arrLine[2]);
                    }
                }
            }
            Animal animal = new Animal(arrLine[0], arrLine[1], arrLine[2], commandStr);
            animalList.add(animal);
        }
        return animalList;
    }

    /**
     * Метод, который принимает список из объектов классов Cat, Dog или Hamster и показывает
     * информацию о всех животных
     * @param animalList - список из объектов классов Cat, Dog или Hamster
     */
    static void showAnimals(ArrayList<Animal> animalList) {
        for (Animal animal : animalList) {
            System.out.print(animal.toString());
        }
    }

    /**
     * Метод который принимает список из объектов классов Cat, Dog или Hamster и добавляет
     * новый элемент, сформаированный из данных введенных через терминал.
     *
     * @param animalList - список из объектов классов Cat, Dog или Hamster
     */
    static void addAnimal(ArrayList<Animal> animalList) {
        System.out.printf("Введите имя животного: ");
        Scanner inputName = new Scanner(System.in);
        String name = inputName.nextLine();
        System.out.printf("Введите дату рождения животного в формате ГГГГ-ММ-ДД: ");
        Scanner inputDate = new Scanner(System.in);
        String date = inputDate.nextLine();
        // Определяем класс животного при вводем данныхчерез терминал
        System.out.printf("Выберите вид животного:\n" +
                "1 - Кошка\n" +
                "2 - Собака\n" +
                "3 - Хомяк\n");
        Scanner input = new Scanner(System.in);
        int type = input.nextInt();
        switch (type) {
            case 1 -> {
                Cat cat = new Cat(name, date, "cat");
                animalList.add(cat);
            }
            case 2 -> {
                Dog dog = new Dog(name, date, "dog");
                animalList.add(dog);
            }
            case 3 -> {
                Hamster hamster = new Hamster(name, date, "hamster");
                animalList.add(hamster);
            }
        }
    }

    /**
     * Метод, который принимает список из объектов классов Cat, Dog или Hamster и добавляет
     * команды к выбранному пользователем животному
     * @param animalList - список из объектов классов Cat, Dog или Hamster
     */
    static void teachAnimal(ArrayList<Animal> animalList) {
        System.out.println("Введите имя животного, которое нужно научить команде: ");
        showAnimals(animalList);
        Scanner inputName = new Scanner(System.in);
        String name = inputName.nextLine();
        for (Animal animal : animalList) {
            if (animal.getName().equals(name)) {
                System.out.printf("Ведите команду для обучения: ");
                Scanner inputCommand = new Scanner(System.in);
                String command = inputCommand.nextLine();
                animal.setCommands(command);
            }
        }
    }

    static void saveChanges(ArrayList<Animal> animalList, File file) {
        try (PrintWriter animalStrWriter = new PrintWriter(new FileWriter(file), true)) {
            for (Animal animal : animalList) {
                animalStrWriter.printf("%s-%s-%s-%s\n", animal.getName(), animal.getBirthDate(), animal.getType(),
                        animal.getCommandsT());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public String toString() {
        return "Animal: " + this.name + "\t\tDate of birthday: " + this.birthDate +
                "\t\tType: " + this.getType() + "\t\t\tCommands: " + this.getCommands() + "\n";
    }

    static void Menu() {
        System.out.print("Это реестр домашних животных.\n" +
                "Вы можете:\n" +
                "1. Завести животное (клавиша 1)\n" +
                "2. Научить животное новой команде (клаваша 2)\n" +
                "3. Вывести список животных с информацией о них (клаваша 3)\n" +
                "4. Сохранить изменения (клаваша 4)\n" +
                "5. Выйти (клаваша 5)\n" +
                "\n" +
                "Введите команду: ");
    }
}






























