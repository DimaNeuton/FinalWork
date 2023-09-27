package Work;

import java.util.ArrayList;

public class Donkey extends PackAnimal {
    public Donkey(String name, String birthDate, String type) {
        super(name, birthDate, type);
    }

    public Donkey(String name, String birthDate, String type, ArrayList<String> commands) {
        super(name, birthDate, type, commands);
    }

    @Override
    public String toString() {
        return "Donkey: " + super.getName() + "\n" +
               "Date of birthday: " + super.getBirthDate() + "\n" +
               "Commands: " + super.getCommands();
    }
}
