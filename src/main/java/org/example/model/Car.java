package org.example.model;

import org.example.model.enums.Color;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "cars")
public class Car {

    @Id
    @GeneratedValue(generator = "uuid2")
    @GenericGenerator(name = "uuid2", strategy = "uuid2")
    @Column(name = "uuid")
    private String uuid;

    private String brand;
    @Enumerated(EnumType.STRING)
    private Color color;

    private String model;

    private double price;

    @Column(name = "date_of_production")
    private LocalDate dateOfProduction;

    @Column(name = "is_limited_editon")
    private boolean isLimitedEditon;

    @OneToOne(mappedBy = "car", cascade = CascadeType.ALL)
    private Engine engine;


    @OneToMany(mappedBy = "car",
            cascade = CascadeType.ALL)
    private Set<Person> persons
            = new HashSet<>();

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public LocalDate getDateOfProduction() {
        return dateOfProduction;
    }

    public void setDateOfProduction(LocalDate dateOfProduction) {
        this.dateOfProduction = dateOfProduction;
    }

    public boolean isLimitedEditon() {
        return isLimitedEditon;
    }

    public void setLimitedEditon(boolean limitedEditon) {
        isLimitedEditon = limitedEditon;
    }

    public Engine getEngine() {
        return engine;
    }

    public void setEngine(Engine engine) {
        this.engine = engine;
    }

    public Set<Person> getPersons() {
        return persons;
    }

    public void add(Person person){
        person.setCar(this);
        this.persons.add(person);
    }

    public void remove(Person person){
        this.persons.remove(person);
        person.setCar(null);
    }

    @Override
    public String toString() {
        return "Car{" +
                "uuid='" + uuid + '\'' +
                ", brand='" + brand + '\'' +
                ", color=" + color +
                ", model='" + model + '\'' +
                ", price=" + price +
                ", dateOfProduction=" + dateOfProduction +
                ", isLimitedEditon=" + isLimitedEditon +
                ", engine=" + engine +
                '}';
    }
}
