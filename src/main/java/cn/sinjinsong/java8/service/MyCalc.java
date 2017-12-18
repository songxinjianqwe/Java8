package cn.sinjinsong.java8.service;

public interface MyCalc<T,R> {
	R calc(T t1, T t2);
}
