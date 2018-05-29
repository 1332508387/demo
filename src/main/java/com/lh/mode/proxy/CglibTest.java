package com.lh.mode.proxy;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * 使用 Cglib 实现动态代理：目标对象不需要实现接口
 */
public class CglibTest {
    static class UserDao {
        public void save() {
            System.out.println("保存用户信息。。。");
        }
    }

    static class TransactionProxy implements MethodInterceptor {
        private Object target;

        public TransactionProxy(Object target) {
            this.target = target;
        }

        public Object getProxy() {
            Enhancer enhancer = new Enhancer();
            // 设置父类
            enhancer.setSuperclass(target.getClass());
            // 设置回调
            enhancer.setCallback(this);
            // 创建子类
            return enhancer.create();
        }

        @Override
        public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
            System.out.println("开启事务");
            method.invoke(target);
            System.out.println("提交事务");
            return null;
        }
    }

    public static void main(String[] args) {
        TransactionProxy proxy = new TransactionProxy(new UserDao());
        UserDao userDao = (UserDao) proxy.getProxy();
        userDao.save();
    }
}
