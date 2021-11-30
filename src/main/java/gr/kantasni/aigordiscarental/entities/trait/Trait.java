package gr.kantasni.aigordiscarental.entities.trait;

import com.fasterxml.jackson.annotation.JsonIgnore;
import gr.kantasni.aigordiscarental.entities.PersistableEntity;
import gr.kantasni.aigordiscarental.entities.language.Content;
import gr.kantasni.aigordiscarental.entities.vehicle.Vehicle;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@Entity
@Table(name = "trait")
public class Trait extends PersistableEntity {

    @ManyToOne
    private TraitType type;

    @OneToMany(cascade = CascadeType.ALL)
    private List<Content> contents = new ArrayList<>();

    @JsonIgnore
    @ManyToMany(mappedBy = "traits", fetch = FetchType.LAZY)
    private List<Vehicle> vehicle = new ArrayList<>();

    public void addContent(Content content){ this.contents.add(content); }

//    public Trait fromRequest(TraitType traitType,String language,String text){
//        this.type = traitType;
//
//        Content content = new Content();
//        content.setEntity(this);
//        content.setLanguage(new Language());
//    }

}