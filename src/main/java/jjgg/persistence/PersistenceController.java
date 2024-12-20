package jjgg.persistence;

import jjgg.logic.Car;

import java.util.List;

public class PersistenceController {
    AutoController autoController = new AutoController();

    public void createCar(Car car){
        autoController.createcar(car);
    }

    public void updateCar(Car car){
        autoController.updatecar(car);
    }

    public List<Car> getAllCars(){
        return autoController.getAllCars();
    }

    public Car getCarByModel(String model){
        return autoController.getCarbyModel(model);
    }

    public void deleteCar(Car car){
        autoController.deletecar(car);
    }
}
