package org.example.model;

import org.example.model.enums.FuelType;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

@Entity
@Table(name = "engines")
public class Engine {

    @Id
    @GeneratedValue(generator = "uuid2")
    @GenericGenerator(name = "uuid2", strategy = "uuid2")
    @Column(name = "uuid")
    private String uuid;

    private int power;
    @Enumerated(EnumType.STRING)
    private FuelType fuelType;

    @OneToOne
    @JoinColumn(name = "car_uuid", referencedColumnName = "uuid")
    private Car car;

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    public int getPower() {
        return power;
    }

    public void setPower(int power) {
        this.power = power;
    }

    public FuelType getFuelType() {
        return fuelType;
    }

    public void setFuelType(FuelType fuelType) {
        this.fuelType = fuelType;
    }

    public Car getCar() {
        return car;
    }

    public void setCar(Car car) {
        this.car = car;
    }

    @Override
    public String toString() {
        return "Engine{" +
                "uuid='" + uuid + '\'' +
                ", power=" + power +
                ", fuelType=" + fuelType +
                ", car=" + car +
                '}';
    }
}
