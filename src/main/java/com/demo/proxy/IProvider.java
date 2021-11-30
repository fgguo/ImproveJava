package com.demo.proxy;

/**
 * @author fuguo
 * @date 2021/10/30 10:50 下午
 */

/**

 * @param
 * @description: 把Json字符串解析为Object
 * @return:
 * @author: fuguo
 * @date: 2021/11/30
 */

public interface IProvider {
    Object getData(String json);
}
