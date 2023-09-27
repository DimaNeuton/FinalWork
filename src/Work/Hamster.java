package Work;

import java.util.ArrayList;

public class Hamster extends Pet {
    public Hamster(String name, String birthDate, String type) {
        super(name, birthDate, type);
    }

    public Hamster(String name, String birthDate, String type, ArrayList<String> commands) {
        super(name, birthDate, type, commands);
    }
}
