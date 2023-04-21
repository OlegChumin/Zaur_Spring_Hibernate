package factory_patterns.abstract_factory;
/**
 */
public class Main {
    public static void main(String[] args) {
        AbstractFactory mercedesFactory =  new MercedesFactory();
        AbstractFactory bmwFactory = new BMWFactory();

        Car mercedes = mercedesFactory.getCar();
        mercedes.drive();
        Bike mercedes_bike = mercedesFactory.getBike();
        mercedes_bike.drive();

        Car bmw = bmwFactory.getCar();
        bmw.drive();
        Bike bmw_bike = bmwFactory.getBike();
        bmw_bike.drive();
    }
}

interface Car {
    void drive();
}

interface Bike {
    void drive();
}

class Mercedes implements Car {

    @Override
    public void drive() {
        System.out.println("Drive Mercedes");
    }
}

class BMW implements Car {

    @Override
    public void drive() {
        System.out.println("Drive BMW");
    }
}

class MercedesBike implements Bike {

    @Override
    public void drive() {
        System.out.println("Drive Mercedes_Bike");
    }
}

class BMWBike implements Bike {

    @Override
    public void drive() {
        System.out.println("Drive BMW_Bike");
    }
}

interface AbstractFactory {
    Car getCar();
    Bike getBike();
}

class MercedesFactory implements AbstractFactory {

    @Override
    public Car getCar() {
        return new Mercedes();
    }

    @Override
    public Bike getBike() {
        return new MercedesBike();
    }
}

class BMWFactory implements AbstractFactory {

    @Override
    public Car getCar() {
        return new BMW();
    }

    @Override
    public Bike getBike() {
        return new BMWBike();
    }
}
