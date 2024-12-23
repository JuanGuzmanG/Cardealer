package jjgg.logic;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Car {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String model;
    private String brand;
    private String motor;
    private String color;
    private String registration;
    private int doors;

    //constructors
    public Car() {}
    public Car(String model, String brand, String motor, String color, String registration, int doors) {
        this.model = model;
        this.brand = brand;
        this.motor = motor;
        this.color = color;
        this.registration = registration;
        this.doors = doors;
    }
    public Car(Long id, String model, String brand, String motor, String color, String registration, int doors) {
        this.id = id;
        this.model = model;
        this.brand = brand;
        this.motor = motor;
        this.color = color;
        this.registration = registration;
        this.doors = doors;
    }

    public Long getId(){return id;}
    public void setId(Long id){this.id = id;}

    public String getModel(){return model;}
    public void setModel(String model){this.model = model;}

    public String getBrand(){return brand;}
    public void setBrand(String brand){this.brand = brand;}

    public String getMotor(){return motor;}
    public void setMotor(String motor){this.motor = motor;}

    public String getColor(){return color;}
    public void setColor(String color){this.color = color;}

    public String getRegistration(){return registration;}
    public void setRegistration(String registration){this.registration = registration;}

    public int getDoors(){return doors;}
    public void setDoors(int doors){this.doors = doors;}

    public String toString(){
        return model + "-" + color;
    }
}
