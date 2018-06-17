package com.lh.mode.proxy;

/**
 * 静态代理：可以做到在不修改目标对象的功能前提下,对目标功能扩展
 * 缺点：因为代理对象需要与目标对象实现一样的接口,所以会有很多代理类,类太多.同时,一旦接口增加方法,目标对象与代理对象都要维护
 */
public class StaticProxyTest {
    interface IUserDao {
        void save();
    }

    static class UserDao implements IUserDao {
        @Override
        public void save() {
            System.out.println("保存用户信息。。。");
        }
    }

    static class UserDaoProxy implements IUserDao {
        private IUserDao userDao;

        public UserDaoProxy(IUserDao userDao) {
            this.userDao = userDao;
        }

        @Override
        public void save() {
            System.out.println("开启事务");
            userDao.save();
            System.out.println("提交事务");
        }
    }

    public static void main(String[] args) {
        UserDaoProxy proxy = new UserDaoProxy(new UserDao());
        proxy.save();
    }
}
