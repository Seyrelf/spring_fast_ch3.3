package ch1.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.*;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.annotation.PersistenceCreator;
import org.springframework.data.annotation.Persistent;
import org.springframework.data.domain.Persistable;
import org.springframework.data.relational.core.mapping.Table;

import java.lang.annotation.Annotation;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor(access= AccessLevel.PROTECTED, force=true)
public class Ingredient{

    @Id
    private String id;
    private String name;
    private  Type type;

    public enum Type{
        DOUGH,PROTEIN,VEGGIES,CHEESE,SAUCE
    }

    @Override
    public String toString() {
        return "Ingredient{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", type=" + type +
                '}';
    }

}
