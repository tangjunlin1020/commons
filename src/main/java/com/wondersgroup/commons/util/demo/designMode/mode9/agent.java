package com.wondersgroup.commons.util.demo.designMode.mode9;

/**
 *   代理模式
 *   指由一个代理主题来操作真实主题，真实主题执行具体的业务操作，而代理主题负责其他相关业务的处理。比如生活中的通过代理访问网络，客户通过网络代理连接网络（具体业务），由代理服务器完成用户权限和访问限制等与上网相关的其他操作（相关业务）。
 *
 * @author tangjunlin
 * @date 2022/12/16 14:24
 */
public class agent {
    //定义Network接口类
    public static interface Network {
        //定义一个浏览的抽象方法
        public void browse();
    }

    //真实的上网操作类实现Network接口类 Real.java
    public static class Real implements Network {
        @Override
        //重写抽象方法
        public void browse() {
            System.out.println("上网浏览信息........");
        }
    }

    //代理上网类实现Network接口类 Proxy.java
    public static class Proxy implements Network{
        private Network network;//上网接口
        //设置代理的真实操作
        public Proxy(Network network){
            // 设置代理的子类
            this.network=network;
        }
        //身份验证操作 其他操作
        public void check(){
            System.out.println("验证账号密码是否合法");
        }
        @Override
        //代码实现上网
        public void browse(){
            //调用具体的代理业务操作
            this.check();
            //调用真实的上网操作
            this.network.browse();
        }
    }

    public static void main(String[] args){
        //定义接口对象
        Network network=null;
        //实例化代理，同时传入代理的真实操作
        network=new Proxy(new Real());
        //调用代理的上网操作
        network.browse();
    }



}
