package factory_patterns.factory_method;
/**
 * в паттерне фабричный метод мы создаем абстрактный класс с общей логикой и кодом, а также абстрактный метод,
 * который должен быть реализован в подклассах для создания конкретных объектов.
 *
 * Абстрактный класс содержит метод, который вызывает фабричный метод для создания объекта. Этот метод может содержать
 * общую логику и код для всех подклассов.
 *
 * Абстрактный метод фабрики определяет интерфейс для создания объектов, но не реализует его. Этот метод должен быть
 * реализован подклассами для создания конкретных объектов. Таким образом, мы можем создавать объекты разных типов,
 * не зависимо от конкретной реализации объекта.
 *
 * При использовании паттерна фабричный метод мы отделяем процесс создания объекта от процесса использования объекта.
 * Это позволяет нам легко изменять тип создаваемых объектов, не внося изменений в код, который использует эти объекты.
 *
 * Кроме того, паттерн фабричный метод позволяет нам сосредоточиться на производстве объектов в рамках определенной
 * семейства объектов, что делает код более универсальным и гибким.
 *
 * Таким образом, паттерн фабричный метод позволяет нам создавать объекты с помощью абстрактных методов и классов,
 * что делает код более гибким и универсальным.
 * */
public class Main {
    public static void main(String[] args) {
        CarFactory carFactory= new MercedesFactory();
        carFactory.crateCar(); // creates Mercedes car

        CarFactory carFactoryBMW =  new BMWFactory();
        carFactoryBMW.crateCar(); // creates BMW car
    }
}

interface Car {
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

//class MercedesFactory {
//    public void createCar() {
//        Car car = new Mercedes();
//        car.drive();
//        //.. more code
//    }
//}
//
//class BMWFactory {
//    public void createCar() {
//        Car car = new BMW();
//        car.drive();
//        //..more code
//
//    }
//}

abstract class CarFactory {
    public void crateCar() {
        Car car = getCar();
        car.drive();
        //...other logic and code
    }

    abstract Car getCar();
}

class MercedesFactory extends CarFactory {

    @Override
    Car getCar() {
        return new Mercedes();
    }

//    {
//        new MercedesFactory().crateCar();
//    }
}

class BMWFactory extends CarFactory {

    @Override
    Car getCar() {
        return new BMW();
    }
}