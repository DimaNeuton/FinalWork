package Work;

import java.util.ArrayList;

public class Horse extends PackAnimal {
    public Horse(String name, String birthDate, String type) {
        super(name, birthDate, type);
    }

    public Horse(String name, String birthDate, String type, ArrayList<String> commands) {
        super(name, birthDate, type, commands);
    }

    @Override
    public String toString() {
        return "Horse: " + super.getName() + "\n" +
               "Date of birthday: " + super.getBirthDate() + "\n" +
               "Commands: " + super.getCommands();
    }
}
