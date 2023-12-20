package com.ttknpdev.buildbasicapiusingspringboot.service;

import java.util.Map;

public interface BooksService<T> {
    Iterable<T> reads();
    T read(String rid);
    T create(T obj);
    T update(T obj , String rid);
    Map<String , T> delete(String rid);
}
