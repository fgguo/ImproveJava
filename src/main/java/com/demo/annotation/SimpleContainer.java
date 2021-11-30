package main.java.com.demo.annotation;

/**
 * @className: SimpleContainer
 * @description: DI容器的类,提供一个方法
 * @author: fuguo
 * @date: 2021/11/30
 **/

import java.io.ObjectStreamException;
import java.lang.reflect.Field;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @param ：需要创建对象的类
 * @description: 创建需要的对象，并配置依赖关系
 * @return: 返回一个对象实例
 * @author: fuguo
 * @date: 2021/11/30
 **/
public class SimpleContainer {
    private static Map<Class<?>, Object> instances = new ConcurrentHashMap<>();

    public static <T> T getInstance(Class<T> cls){
        try {
            boolean singleton = cls.isAnnotationPresent(SimpleSingleton.class);
            if(!singleton){
                return createInstance(cls);
            }
            Object obj = instances.get(cls);
            if(obj != null){
                return (T) (obj);
            }
            synchronized (cls){
                    obj = instances.get(cls);
                    if(obj == null){
                        obj = createInstance(cls);
                        instances.put(cls, obj);
                }
            }
            return (T)obj;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public static <T> T createInstance(Class<T> cls){
        try {
            T obj = cls.newInstance();
            Field[] fields = cls.getDeclaredFields();
            for(Field f : fields){
                if(f.isAnnotationPresent(SimpleInject.class)){
                    if(!f.isAccessible()){
                        f.setAccessible(true);
                    }
                    Class<?> fieldCls = f.getType();
                    f.set(obj, getInstance(fieldCls));
                }
            }
            return obj;
        } catch (InstantiationException e) {
            throw new RuntimeException(e);
        } catch (IllegalAccessException e) {
            throw new RuntimeException(e);
        }
    }
}
