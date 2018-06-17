package com.lh.mode.Factory;

public class CarTest {
    static abstract class Car {
        public abstract void product();
    }

    static class Car1 extends Car {

        @Override
        public void product() {
            System.out.println("生产car1.。。");
        }
    }

    static class  Car2 extends Car {

        @Override
        public void product() {
            System.out.println("生产car2.。。");
        }
    }

    static class CarFactory {

        public CarFactory() {

        }

        public Car getCar(String name) {
            switch (name) {
                case "car1" :
                    return new Car1();
                case "car2" :
                    return new Car2();
                default :
                    throw new RuntimeException();
            }
        }

    }

    public static void main(String[] args) {
        CarFactory carFactory = new CarFactory();
        Car car1 = carFactory.getCar("car1");
        car1.product();
    }
}
