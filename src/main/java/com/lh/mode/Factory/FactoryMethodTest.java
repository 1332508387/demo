package com.lh.mode.Factory;

/**
 * 工厂方法模式
 */
public class FactoryMethodTest {
    interface Shape {
        void draw();
    }

    static class Circle implements Shape {
        @Override
        public void draw() {
            System.out.println("画一个圆。。。");
        }
    }

    static class Rectangle implements Shape {
        @Override
        public void draw() {
            System.out.println("画一个矩形。。。");
        }
    }

    interface ShapeFactory {
        Shape getShape();
    }

    static class CircleFactory implements ShapeFactory {
        @Override
        public Shape getShape() {
            return new Circle();
        }
    }

    static class RectangleFactory implements ShapeFactory {
        @Override
        public Shape getShape() {
            return new Rectangle();
        }
    }

    public static void main(String[] args) {
        Shape shape = new CircleFactory().getShape();
        shape.draw();
    }
}
