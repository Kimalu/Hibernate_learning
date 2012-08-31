package com.Kimalu.model;

 
import java.util.HashSet;
import java.util.Set;

 
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;

 
@Entity
public class Team {
    @Id
    @GeneratedValue
    private int id;
    private String name;
    @OneToMany
    @JoinColumn(name="teamId")                    
    private Set<Person> personSet=new HashSet<Person>();
 
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public Set<Person> getPersonSet() {
        return personSet;
    }
    public void setPersonSet(Set<Person> personSet) {
        this.personSet = personSet;
    }

 
}

