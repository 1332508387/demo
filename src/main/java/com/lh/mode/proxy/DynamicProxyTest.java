package com.lh.mode.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * 动态代理
 */
public class DynamicProxyTest {
    public static void main(String[] args) {
        Student student = new Student();
        StudentProxy proxy = new StudentProxy(student);
        Work work = (Work) proxy.getProxy();
        work.doWork();
    }

    interface Work {
        void doWork();
    }

    static class Student implements Work {
        public void doWork() {
            System.out.println("我是学生写作业。。。");
        }

        public void play() {
            System.out.println("play...");
        }
    }

    static class StudentProxy implements InvocationHandler {
        private Student student;

        public StudentProxy(Student student) {
            this.student = student;
        }

        @Override
        public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
            System.out.println("我代理学生写作业");
            method.invoke(student);
            System.out.println("写完了。。。");
            return proxy;
        }

        public Object getProxy() {
            return Proxy.newProxyInstance(student.getClass().getClassLoader(), student.getClass().getInterfaces(), this);
        }
    }


}
