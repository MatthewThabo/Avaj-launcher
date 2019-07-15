package classes;

import java.util.*;

public class Tower {
    private List<Flyable> observers = new ArrayList<Flyable>();

    public void register(Flyable flyable) {
        this.observers.add(flyable);
        long id;
        String name;
        if (flyable instanceof Baloon) {
            id = ((Baloon) flyable).getId();
            name = ((Baloon) flyable).getName();
            TextWriter.textWriter.write_to_a_file("Tower says: Baloon# " + name + " (" + id + ") registered to weather tower");
        } else if (flyable instanceof Jetplane) {
            id = ((Jetplane) flyable).getId();
            name = ((Jetplane) flyable).getName();
            TextWriter.textWriter.write_to_a_file("Tower says: Jetplane#" + name + "(" + id + ") registered to weather tower");
        } else if (flyable instanceof Helicopter) {
            id = ((Helicopter) flyable).getId();
            name = ((Helicopter) flyable).getName();
            TextWriter.textWriter.write_to_a_file("Tower says: Helicopter#" + name + "(" + id + ") registered to weather tower");
        }

    }

    public void unregister(Flyable flyable) {
        long id = -1;
        if (flyable instanceof Aircraft)
            id = ((Aircraft) flyable).getId();
        int t = 0;
        for (Flyable obs : observers) {
            if (obs instanceof Aircraft) {
                if (((Aircraft) obs).getId() == id) {
                    break;
                }
            }
            t++;
        }
        if (t > -1) {
            String name;
            if (flyable instanceof Baloon) {
                name = ((Baloon) flyable).getName();
                TextWriter.textWriter.write_to_a_file("Tower says: Baloon# " + name + "(" + id + ") unregistered from weather tower");
            } else if (flyable instanceof Jetplane) {
                name = ((Jetplane) flyable).getName();
                TextWriter.textWriter.write_to_a_file("Tower says: Jetplane# " + name + "(" + id + ") unregistered from weather tower");
            } else if (flyable instanceof Helicopter) {
                name = ((Helicopter) flyable).getName();
                TextWriter.textWriter.write_to_a_file("Tower says: Helicopter# " + name + "(" + id + ") unregistered from weather tower");
            }
            observers.remove(t);
        }
    }

    protected void conditionsChanged()  {
        if (observers.isEmpty() == false) {
            for (int t = 0; t < observers.size(); t++) {
                observers.get(t).updateConditions();
            }

        }
    }
}
