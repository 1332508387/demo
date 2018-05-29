package com.lh.mode.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * 动态代理
 */
public class DynamicProxyTest {
    interface IUserDao {
        void save();
    }

    static class UserDao implements IUserDao {
        @Override
        public void save() {
            System.out.println("保存用户信息。。。");
        }
    }

    static class TransactionProxy implements InvocationHandler {
        private Object target;

        public TransactionProxy(Object target) {
            this.target = target;
        }

        @Override
        public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
            System.out.println("开启事务");
            method.invoke(target);
            System.out.println("提交事务");
            return null;
        }

        public Object getProxy() {
            return Proxy.newProxyInstance(target.getClass().getClassLoader(), target.getClass().getInterfaces(), this);
        }
    }

    public static void main(String[] args) {
        IUserDao userDao = new UserDao();
        TransactionProxy proxy = new TransactionProxy(userDao);
        userDao = (IUserDao) proxy.getProxy();
        userDao.save();
    }

}
