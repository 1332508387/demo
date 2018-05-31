package com.lh.mode.Factory;

import java.util.Collections;

/**
 * 简单工厂模式：工厂类负责创建的对象比较少，客户只需要传入工厂类参数，对于如何创建对象（逻辑）不关心。简单工厂模式很容易违反高内聚低耦合的原则，因此一般只在很简单的情况下使用。
 */
public class StaticFactoryTest {
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

    static class ShapFactory {
        public static final int TYPE_CIRCLE = 0;
        public static final int TYPE_RECTANGLE = 1;

        public Shape getShap(int type) {
            Shape shape = null;
            switch (type) {
                case TYPE_CIRCLE:
                    shape = new Circle();
                    break;
                case TYPE_RECTANGLE:
                    shape = new Rectangle();
                    break;
                default: throw new RuntimeException("没有此类型");
            }
            return shape;
        }
    }

    public static void main(String[] args) {
        ShapFactory factory = new ShapFactory();
//        Shape shap = factory.getShap(ShapFactory.TYPE_CIRCLE);
        Shape shap = factory.getShap(3);
        shap.draw();
    }

}
