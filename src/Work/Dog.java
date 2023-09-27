package Work;

import java.util.ArrayList;

public class Dog extends Pet {
    public Dog(String name, String birthDate, String type) {
        super(name, birthDate, type);
    }

    public Dog(String name, String birthDate, String type, ArrayList<String> commands) {
        super(name, birthDate, type, commands);
    }
}
