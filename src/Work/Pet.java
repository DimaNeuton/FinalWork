package Work;

import java.util.ArrayList;

public class Pet extends Animal {

    public Pet(String name, String birthDate, String type) {
        super(name, birthDate, type);
    }

    public Pet(String name, String birthDate, String type, ArrayList<String> commands) {
        super(name, birthDate, type, commands);
    }
}
