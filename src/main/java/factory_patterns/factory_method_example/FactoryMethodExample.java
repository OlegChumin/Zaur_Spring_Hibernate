package factory_patterns.factory_method_example;

public class FactoryMethodExample {

    // Интерфейс для создания разных типов автомобилей
    interface Car {
        void drive(); // Абстрактный метод
    }

    // Конкретный класс Mercedes, реализующий интерфейс Car
    static class Mercedes implements Car {
        @Override
        public void drive() {
            System.out.println("Drive Mercedes");
        }
    }

    // Конкретный класс BMW, реализующий интерфейс Car
    static class BMW implements Car {
        @Override
        public void drive() {
            System.out.println("Drive BMW");
        }
    }

    // Абстрактный класс для фабрики, реализующий общую логику для всех фабрик
    static abstract class CarFactory {
        // Метод, который использует фабричный метод для создания автомобиля
        public void createCar() {
            // Получаем конкретный автомобиль из фабричного метода
            Car car = getCar();
            // Запускаем метод для езды на автомобиле
            car.drive();
            // ...дополнительная логика и код
        }

        // Абстрактный метод, который должен быть реализован в подклассах
        abstract Car getCar();
    }

    // Конкретный класс фабрики Mercedes, наследующий абстрактный класс CarFactory
    static class MercedesFactory extends CarFactory {
        @Override
        // Реализация абстрактного метода для создания Mercedes
        Car getCar() {
            return new Mercedes();
        }

        // Пример использования фабрики
        public static void main(String[] args) {
            new MercedesFactory().createCar();
        }
    }

    // Конкретный класс фабрики BMW, наследующий абстрактный класс CarFactory
    static class BMWFactory extends CarFactory {
        @Override
        // Реализация абстрактного метода для создания BMW
        Car getCar() {
            return new BMW();
        }

        // Пример использования фабрики
        public static void main(String[] args) {
            new BMWFactory().createCar();
        }
    }

}
