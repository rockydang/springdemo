package com.mogujie.service.springdemo.common.generic;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by yanxiao on 16/4/23.
 */
public class Favorites {

    private Map<Class<?>, Object> favorites = new HashMap<Class<?>, Object>();

  /*  public <T> void putFavorite(Class<T> type, T instance) {
        if (type == null) {
            throw new NullPointerException("type is null");
        }
        favorites.put(type, instance);
    }*/

    public <T> void putFavorite(Class<T> type, T instance) {
        if (type == null) {
            throw new NullPointerException("type is null");
        }
        favorites.put(type, type.cast(instance));
    }

    public <T> T getFavorite(Class<T> type) {
        return type.cast(favorites.get(type));
    }

    public static void main(String[] args) {
        Favorites f = new Favorites();
        f.putFavorite(String.class,"Java");
        f.putFavorite(Integer.class,0xcafebabe);
        f.putFavorite(Class.class,Favorites.class);

        String fstr = f.getFavorite(String.class);
        int fInt = f.getFavorite(Integer.class);
        Class<?> fClass = f.getFavorite(Class.class);

        System.out.printf("%s %x %s%n", fstr, fInt, fClass.getName());
    }

}
