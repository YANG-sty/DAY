package com.sys.testMy;

import org.junit.Test;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * 多态
 * @author y_zzu 2020-10-28-17:47
 */
public class Polymorphism {
    @Test
    public void test1() throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        //获得 animalmethod 中的 print 方法
        Method animalMethod = Animal.class.getDeclaredMethod("print");
        Method catMethod = Cat.class.getDeclaredMethod("print");

        Animal animal = new Animal();
        Cat cat = new Cat();
        // 使用 cat 调用 animal 中的 printf 方法 ， animalMethod 表达的是 Animal中的 print 方法
        animalMethod.invoke(cat);
        // 使用 animal 调用 animal 中的 print 方法
        animalMethod.invoke(animal);

        //使用 cat 调用 cat 中的 print 方法
        catMethod.invoke(cat);
        //使用 animal 调用 cat 中的 print 方法，由于 catMethod 的标记是 cat 中的 print 方法，父类 animal 无法访问 子类的方法（父类引用指向子类对象, 才能直接方法子类的方法)
        catMethod.invoke(animal);
    }

    class Animal {

        public void print() {
            System.out.println("Animal.print()");
        }

    }

    class Cat extends Animal {

        @Override
        public void print() {
            System.out.println("Cat.print()");
        }

    }

}
