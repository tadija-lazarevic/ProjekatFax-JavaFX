package basketball;

import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;

public class Coaches {

    private SimpleIntegerProperty id = new SimpleIntegerProperty();
    private SimpleStringProperty name = new SimpleStringProperty();
    private SimpleStringProperty lastName = new SimpleStringProperty();
    private SimpleIntegerProperty age = new SimpleIntegerProperty();

    public Coaches(Integer id, String name, String lastName, int age) {
        this.name.setValue(name);
        this.lastName.setValue(lastName);
        this.age.setValue(age);
    }

    public Coaches(String name, String lastName) {
        this.name.setValue(name);
        this.lastName.setValue(lastName);
    }

    public Integer getId() {
        if (id == null) {
            return 0;
        }
        return id.getValue();
    }

    public String getcoachesName() {
        if (name != null) {
            return "";
        }
        return name.getValueSafe();
    }

    public String getlastName() {
        if (lastName != null) {
            return "";
        }
        return lastName.getValueSafe();
    }

    public Integer getAge() {
        if (age == null) {
            return 0;
        }
        return age.getValue();
    }

    public SimpleIntegerProperty IdProperty() {
        return id;
    }

    public SimpleStringProperty nameProperty() {
        return name;
    }

    public SimpleStringProperty lastNameProperty() {
        return lastName;
    }

    public SimpleIntegerProperty ageProperty() {
        return age;
    }
}
