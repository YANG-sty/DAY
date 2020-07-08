package com.sys.DesignPatterns.BuilderPatterns.v1;

/**
 * Create by yang_zzu on 2020/7/7 on 20:28
 */
public class BuilderPatternsTest {
    public static void main(String[] args) {
        //创建一个建造者
        DefaultConcreteProductBuilder defaultConcreteProductBuilder = new DefaultConcreteProductBuilder();
        Director director = new Director(defaultConcreteProductBuilder);
        Product product = director.makeProduct("xljx-0001", "华为", "1", "2", "3", "4", "5", "6");
        System.out.println(product);


        /*SpecalConcreteProductBuilder specalConcreteProductBuilder = new SpecalConcreteProductBuilder();
        Director director1 = new Director(specalConcreteProductBuilder);
        Product product1 = director1.makeProduct("xljx-0001", "华为", "1", "2", "3", "4", "5", "6");
        System.out.println(product1);*/

    }
}
