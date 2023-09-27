package Work;

import java.util.ArrayList;

public class Camel extends PackAnimal {
    public Camel(String name, String birthDate, String type) {
        super(name, birthDate, type);
    }

    public Camel(String name, String birthDate, String type, ArrayList<String> commands) {
        super(name, birthDate, type, commands);
    }

    @Override
    public String toString() {
        return "Camel: " + super.getName() + "\n" +
               "Date of birthday: " + super.getBirthDate() + "\n" +
               "Commands: " + super.getCommands();
    }
}
