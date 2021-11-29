package com.demo.proxy;

/**
 * @author fuguo
 * @date 2021/10/30 10:50 下午
 */

//接口，把Json字符串解析为Object
public interface IProvider {
    Object getData(String json);
}
