package factory_patterns.abstract_factory_better_example;

public class Main {
    public static void main(String[] args) {
        AbstractFactory<Car, Bike> mercedesFactory = new MercedesFactory();
        AbstractFactory<Car, Bike> bmwFactory = new BMWFactory();

        Car mercedes = mercedesFactory.createFirst();
        mercedes.drive();
        Bike mercedes_bike = mercedesFactory.createSecond();
        mercedes_bike.drive();

        Car bmw = bmwFactory.createFirst();
        bmw.drive();
        Bike bmw_bike = bmwFactory.createSecond();
        bmw_bike.drive();
    }
}

abstract class Car {
    abstract void drive();
}

abstract class Bike {
    abstract void drive();
}

class Mercedes extends Car {
    @Override
    public void drive() {
        System.out.println("Drive Mercedes");
    }
}

class BMW extends Car {
    @Override
    public void drive() {
        System.out.println("Drive BMW");
    }
}

class MercedesBike extends Bike {
    @Override
    public void drive() {
        System.out.println("Drive Mercedes_Bike");
    }
}

class BMWBike extends Bike {
    @Override
    public void drive() {
        System.out.println("Drive BMW_Bike");
    }
}

/**
 * Здесь мы определяем интерфейс AbstractFactory, который имеет два обобщенных типа T и U.
 * Эти обобщенные типы позволяют определить типы объектов, которые будут созданы фабрикой.
 * Метод createFirst() должен создавать объект типа T, а метод createSecond() должен создавать объект типа U. Оба метода
 * объявлены без параметров и возвращают объекты заданных типов.
 * Это позволяет нам создавать различные объекты в рамках одной фабрики и не ограничиваться созданием объектов одного
 * типа. Например, в нашем примере мы можем создать фабрику для создания объектов типа Car и Bike, используя один и
 * тот же интерфейс AbstractFactory:
 * */

interface AbstractFactory<T, U> {
    T createFirst();
    U createSecond();
}

class MercedesFactory implements AbstractFactory<Car, Bike> {
    @Override
    public Car createFirst() {
        return new Mercedes();
    }

    @Override
    public Bike createSecond() {
        return new MercedesBike();
    }
}

class BMWFactory implements AbstractFactory<Car, Bike> {
    @Override
    public Car createFirst() {
        return new BMW();
    }

    @Override
    public Bike createSecond() {
        return new BMWBike();
    }
}
