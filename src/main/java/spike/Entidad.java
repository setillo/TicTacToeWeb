package spike;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Entidad implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    private int id;
    
    private String name;

    private String description;

    public Entidad() {
    }

    public Entidad(int id, String name, String description) {
        this.id = id;
        this.name = name;
        this.description = description;
    }

    // Getters & setters
    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return this.description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

}
