package com.bupt.cad.mapper;

public interface BaseDao<T> {
//    int getTotalNum(T t);
    //增
    boolean add(T data);
    //delete
    boolean delete(int id);
    //update
    boolean update(T data);
    //select
    boolean select(int id);

}
