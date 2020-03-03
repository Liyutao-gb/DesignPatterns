package com.liyutao.dp.chainofresponsibility;

import java.util.ArrayList;
import java.util.List;

/**
 * @auther lytstart
 * @create 2020-02-25-16:00
 *
 * 模拟场景：在论坛中发表文章
 *          后台要经过信息处理才可以发表或者进入数据库
 */
public class Main {
    public static void main(String[] args) {
        Msg msg = new Msg();
        msg.setMsg("大家好:)，<script>，欢迎访问baidu.com，大家都是996 ");

        FilterChain fc = new FilterChain();
        fc.add(new HTMLFilter())
                .add(new SensitiveFilter());  //小技巧

        FilterChain fc2 = new FilterChain();
        fc2.add(new FaceFilter())
                .add(new URLFilter());

        fc.add(fc2);
//        fc.doFilter(msg);
//        fc2.doFilter(msg);

        fc.doFilter(msg);
        System.out.println(msg);
    }
}

class Msg {
    String name;
    String msg;

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    @Override
    public String toString() {
        return "Msg{" +
                "msg='" + msg + '\'' +
                '}';
    }
}

interface Filter {
    boolean doFilter(Msg m); // 返回false，不往下继续执行；返回true，再继续往下执行。
}

class HTMLFilter implements Filter {

    @Override
    public boolean doFilter(Msg msg) {
        String r = msg.getMsg();
        r = r.replace('<', '[');
        r = r.replace('>', ']');
        msg.setMsg(r);
        return true;
    }
}

class SensitiveFilter implements Filter {

    @Override
    public boolean doFilter(Msg msg) {
        String r = msg.getMsg();
        r =r.replaceAll("996", "955");
        msg.setMsg(r);
        return false;
    }
}

class FaceFilter implements Filter {

    @Override
    public boolean doFilter(Msg msg) {
        String r = msg.getMsg();
        r =r.replace(":)", "^V^");
        msg.setMsg(r);
        return true;
    }
}

class URLFilter implements Filter {

    @Override
    public boolean doFilter(Msg msg) {
        String r = msg.getMsg();
        r =r.replaceAll("baidu.com", "http://www.baidu.com");
        msg.setMsg(r);
        return true;
    }
}

class FilterChain implements Filter {
    List<Filter> filters = new ArrayList<>();

//    public void add(Filter f) {
//        filters.add(f);
//    }
    public FilterChain add(Filter f) {
        filters.add(f);
        return this;
    }

    public boolean doFilter(Msg msg) {
        for (Filter f : filters) {
//            f.doFilter(msg);
            if (!f.doFilter(msg)) return false; // 有可能不往下继续执行
        }
        return true;
    }
}