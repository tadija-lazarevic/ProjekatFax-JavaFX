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

    private SimpleIntegerProperty id = new SimpleIntegerProperty();
    private SimpleStringProperty name = new SimpleStringProperty();
    private SimpleStringProperty from = new SimpleStringProperty();
    private SimpleIntegerProperty points = new SimpleIntegerProperty();

    public Teams(Integer id, String name, String from, int points) {
        this.name.setValue(name);
        this.from.setValue(from);
        this.points.setValue(points);
    }

    public Integer getId() {
        if (id == null) {
            return 0;
        }
        return id.getValue();
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

    public SimpleIntegerProperty idProperty() {
        return id;
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
