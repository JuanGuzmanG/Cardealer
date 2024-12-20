package jjgg.logic;

import jjgg.persistence.PersistenceController;

import java.util.List;

public class Controller {
    PersistenceController pc = new PersistenceController();

    //----create car
    public void createCar(String model,String brand,String motor,String color,String registration,int doors){
        Car car = new Car(model,brand,motor,color,registration,doors);
        pc.createCar(car);
    }

    //----update car
    public void updatecar(Long id,String model,String brand,String motor,String color,String registration,int doors){
        Car c = new Car(id,model,brand,motor,color,registration,doors);
        pc.updateCar(c);
    }

    //----get all cars
    public List<Car> getAllCars(){
        return pc.getAllCars();
    }

    //----get car by model
    public Car getCarByModel(String model){
        return pc.getCarByModel(model);
    }

    //----delete car
    public void deleteCar(Car car){
        pc.deleteCar(car);
    }
}
