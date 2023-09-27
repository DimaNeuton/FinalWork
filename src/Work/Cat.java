package Work;

import java.util.ArrayList;

public class Cat extends Pet {
    public Cat(String name, String birthDate, String type) {
        super(name, birthDate, type);
    }

    public Cat(String name, String birthDate, String type, ArrayList<String> commands) {
        super(name, birthDate, type, commands);
    }
}
