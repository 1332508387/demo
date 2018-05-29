package com.lh.mode.proxy;

/**
 * 静态代理
 */
public class StaticProxyTest {
    interface Work {
        void doWork();
    }

    static class Student implements Work {
        @Override
        public void doWork() {
            System.out.println("学生自己写作业。。。");
        }
    }

    static class StudentProxy implements Work {
        private Work work;

        public StudentProxy(Student student) {
            this.work = student;
        }

        @Override
        public void doWork() {
            System.out.println("我代理学生写作业。。。");
            work.doWork();
        }
    }

    public static void main(String[] args) {
        StudentProxy proxy = new StudentProxy(new Student());
        proxy.doWork();
    }
}
