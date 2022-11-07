package org.example;

import org.example.model.Car;
import org.example.model.Engine;
import org.example.model.Person;
import org.example.model.enums.Color;
import org.example.model.enums.FuelType;
import org.example.repository.CarRepository;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;
import java.util.UUID;

public class CarManagmentApp {

    public static void main(String[] args) {
//        testGetAll();
        testInsert();

//        testGetById();
//        testUpdate();
//        testDelete();
    }

    private static void testGetAll() {
        CarRepository carRepository = new CarRepository();
        List<Car> cars = carRepository.getAll();
        System.out.println(cars);
    }

    private static void testInsert() {
        Car car = createCar();

        CarRepository carRepository = new CarRepository();
        carRepository.insert(car);
    }

    private static Car createCar(){
        Car car = new Car();
        car.setBrand("Mercedez-Benz");
        car.setColor(Color.RED);
        car.setModel("Katerfenesh");
        car.setPrice(1_200);
        car.setDateOfProduction(LocalDate.of(1997, Month.FEBRUARY, 10));
        car.setLimitedEditon(false);

        Engine engine = new Engine();
        engine.setPower(700);
        engine.setFuelType(FuelType.DIESEL);
        engine.setCar(car);

        car.setEngine(engine);

        Person person1 = new Person();
        person1.setName("Kelvin");

        Person person2 = new Person();
        person2.setName("Dervishllari");

        car.add(person1);
        car.add(person2);

        return car;
    }

    private static void testGetById() {
        int id = 6;

        CarRepository carRepository = new CarRepository();
        Car car = carRepository.getById(id);

        System.out.println(car);
    }

    private static void testUpdate() {
        Car car = createCarForUpdate();

        CarRepository carRepository = new CarRepository();
        carRepository.update(car);
    }

    private static Car createCarForUpdate() {
        Car car = new Car();
        car.setBrand("Audi");
        car.setColor(Color.GREY);
        car.setModel("A4");
        car.setPrice(1_700);
        car.setDateOfProduction(LocalDate.of(1997, Month.FEBRUARY, 10));
        car.setLimitedEditon(false);

        return car;
    }

    private static void testDelete() {
        int id = 6;

        CarRepository carRepository = new CarRepository();
        carRepository.delete(id);
    }
}
