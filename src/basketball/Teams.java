package basketball;

import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;

/**
 * @author tadija
 * @author lazarevic.tadija@gmail.com
 *
 */
// Klasa tim
public class Teams {

    private SimpleStringProperty name = new SimpleStringProperty();
    private SimpleStringProperty from = new SimpleStringProperty();
    private SimpleIntegerProperty points = new SimpleIntegerProperty();

    public Teams(String name, String from, int points) {
        this.name.setValue(name);
        this.from.setValue(from);
        this.points.setValue(points);
    }

    public String getName() {
        if (name != null) {
            return "";
        }
        return name.getValueSafe();
    }

    public String getFrom() {
        if (from != null) {
            return "";
        }
        return from.getValueSafe();
    }

    public Integer getPoints() {
        if (points == null) {
            return 0;
        }
        return points.getValue();
    }

    public SimpleStringProperty nameProperty() {
        return name;
    }

    public SimpleStringProperty fromProperty() {
        return from;
    }

    public SimpleIntegerProperty pointsProperty() {
        return points;
    }

}
