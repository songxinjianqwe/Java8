package cn.sinjinsong.java8.service;
@FunctionalInterface
public interface MyPredicate <T>{
	boolean isValid(T t);
}
