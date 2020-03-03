package com.liyutao.dp.chainofresponsibility.servlet.v4;

import java.util.ArrayList;
import java.util.List;

/**
 * @auther lytstart
 * @create 2020-02-25-16:00
 *
 * 模拟场景：在论坛中发表文章
 *          后台要经过信息处理才可以发表或者进入数据库
 *
 * 思考：过滤两个东西Request，Response。
 *      Request是从客户端到服务器端，Response是从服务器端到客户端的。
 *
 * 写一个过滤器，既能过滤Request，也能过滤Response。
 *      先过滤request1，request2，再过滤response2，response1。
 *
 * (Servlet的拦截器、struts2的拦截器、Spring MVC的拦截器)
 */
public class Servlet_Main {
    public static void main(String[] args) {
        Request request = new Request();
        request.str = "大家好:)，<script>，欢迎访问baidu.com，大家都是996";
        Response response = new Response();
        response.str = "response";

        FilterChain chain = new FilterChain();
        chain.add(new HTMLFilter()).add(new SensitiveFilter());
        chain.doFilter(request, response);

        System.out.println(request.str);
        System.out.println(response.str);
    }
}

interface Filter {
    boolean doFilter(Request request, Response response, FilterChain chain); // 返回false，不往下继续执行；返回true，再继续往下执行。
}

class Request {
    String str;
}

class Response {
    String str;
}

class HTMLFilter implements Filter {

    @Override
    public boolean doFilter(Request request, Response response, FilterChain chain) {
        request.str = request.str.replaceAll("<", "]").replaceAll(">", "]") + "HTMLFilter()";
        chain.doFilter(request, response);
        request.str += "--HTMLFilter";
        return true;
    }
}

class SensitiveFilter implements Filter {

    @Override
    public boolean doFilter(Request request, Response response, FilterChain chain) {
        request.str = request.str.replaceAll("996", "955") + "SensitiveFilter()";
        chain.doFilter(request, response);
        request.str += "--SensitiveFilter";
        return true;
    }
}

class FilterChain {
    List<Filter> filters = new ArrayList<>();
    int index = 0;

    public FilterChain add(Filter f) {
        filters.add(f);
        return this;
    }

    public boolean doFilter(Request request, Response response) {
        if (index == filters.size())
            return false;

        Filter f = filters.get(index);
        index++;

        return f.doFilter(request, response, this);
    }
}