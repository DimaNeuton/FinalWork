package Work;

import java.util.ArrayList;

public class PackAnimal extends Animal {

    public PackAnimal(String name, String birthDate, String type) {
        super(name, birthDate, type);
    }

    public PackAnimal(String name, String birthDate, String type, ArrayList<String> commands) {
        super(name, birthDate, type, commands);
    }

    @Override
    public String toString() {
        return "PackAnimal: " + super.getName() + "\n" +
               "Date of birthday: " + super.getBirthDate() + "\n" +
               "Commands: " + super.getCommands();
    }
}
