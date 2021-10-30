package com.demo.proxy;

/**
 * @author fuguo
 * @date 2021/10/30 10:52 下午
 */

//接口的实现类
public class SimpleProvider implements IProvider{

    @Override
    public Object getData(String json) {
        //解析JSON，用Null代替
        return null;
    }
}
