package com.lh.mode.Factory;

/**
 * 抽象工厂
 */
public class AbstractFactoryTest {
    static abstract class Engine {
        public abstract void productEngine();
    }

    static class EngineA extends Engine {
        @Override
        public void productEngine() {
            System.out.println("engineA");
        }
    }

    static class EngineB extends Engine {
        @Override
        public void productEngine() {
            System.out.println("engineB");
        }
    }

    static abstract class Light {
        public abstract void productLight();
    }

    static class Light1 extends Light {
        @Override
        public void productLight() {
            System.out.println("light1");
        }
    }

    static class Light2 extends Light {
        @Override
        public void productLight() {
            System.out.println("light2");
        }
    }


    static abstract class AbstractCarFactory {
        public abstract Engine createEngine();
        public abstract Light createLight();
    }

    static class BaoMaFactory extends AbstractCarFactory {
        @Override
        public Engine createEngine() {
            return new EngineA();
        }

        @Override
        public Light createLight() {
            return new Light1();
        }
    }


   static class AoDiFactory extends AbstractCarFactory {
       @Override
       public Engine createEngine() {
           return new EngineB();
       }

       @Override
       public Light createLight() {
           return new Light2();
       }
   }

    public static void main(String[] args) {
        BaoMaFactory baoMaFactory = new BaoMaFactory();
        baoMaFactory.createEngine().productEngine();
        baoMaFactory.createLight().productLight();

        AoDiFactory aoDiFactory = new AoDiFactory();
        aoDiFactory.createEngine().productEngine();
        aoDiFactory.createLight().productLight();
    }

}
