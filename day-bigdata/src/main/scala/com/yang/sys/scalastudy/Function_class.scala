package com.yang.sys.scalastudy

import java.util.Date


class Function_class {


}

object maxFunction {
  def main(args: Array[String]): Unit = {

    //如果不写“=”，那么无论方法体中最后一行计算的结果返回是什么，都会被丢弃，返回Unit
    def max(x: Int, y: Int): Int = {
      if (x > y) {
        return x * 100
      } else {
        return y + 100
      }
    }

    println(max(100, 2))
  }

}

object diGui {
  def main(args: Array[String]): Unit = {

    //递归函数, 显示的声明函数的返回值类型，否则会报错
    def fun(x: Int): Int = {
      if (x == 1) {
        1
      } else {
        x * fun(x - 1)
      }
    }

    println(fun(5))
  }

}

//
object fun1 {

  // 函数的参数有默认值
  def fun(x: Int, y: Int = 15) = {
    x + y
  }

  // 可变长参数的函数
  def fun1(s: String*): String = {
    var sb = ""
    s.foreach((elem: String) => {
      sb = sb + "*" + elem + "*"
    })
    return sb
  }

  /**
   * 匿名函数, 要和调用它的方法放在一起
   * 1."=>"就是匿名函数
   * 2.匿名函数调用要赋值给一个变量，调用直接调用这个变量就可以
   * 3.匿名函数不能显式的写函数返回类型
   */
  val funxy: (Int, Int) => Int = (x: Int, y: Int) => {
    x + y
  }


  // 偏应用函数
  def showLog(date: Date, log: String): String = {
    return ("date is " + date + " ,log is " + log)
  }


  def main(args: Array[String]): Unit = {

    println(fun(10))

    println(fun1("ca", "cb", "cc"))

    //匿名函数, 要和调用它的方法放在一起
    println(funxy(10, 20))

    val date = new Date()
    println(showLog(date, "a"))
    println(showLog(date, "b"))
    println(showLog(date, "c"))

    /**
     * 将普通函数，进行封装，变为，偏应用函数
     * 偏应用函数是一个表达式，将方法中不变的参数写上，变化的参数使用“_”表示，下次直接调用这个偏应用表达式直接传入变化的参数就可以
     */
    var funSL = showLog(date, _: String)
    println(funSL("aaaa"))
    println(funSL("bbbb"))
    println(funSL("cccc"))

  }


}


//
object fun2 {

  //嵌套函数
  def fun(x: Int) = {
    //递归函数，指明返回值类型
    def fun1(num: Int): Int = {
      if (num == 1) {
        1
      } else {
        num * fun1(num - 1)
      }
    }

    //调用递归函数
    fun1(x)
  }


  /**
   * 高阶函数
   *  1.函数的参数是函数
   *  2.函数的返回是函数  --函数的返回是函数时，要显式声明函数的返回类型
   *  3.函数的参数和返回都是函数
   */

  //1.函数的参数是函数
  def fun1(f: (Int, Int) => Int, s: String) = {
    var fresult = f(100, 200)
    fresult + " ----- " + s
  }

  //2.函数的返回是函数, 需要显示的声明返回的函数
  def fun(a: Int, b: Int): (String, String) => String = {
    var ab = a * b

    def fun1(x: String, y: String) = {
      x + "@" + y + "#" + ab
    }

    fun1
  }

  //3.函数的参数和返回都是函数, 对返回的函数进行显示的声明
  def fun(f: (Int, Int) => Int): (String, String) => String = {

    var re = f(1, 2)

    def fun1(x: String, y: String): String = {
      x + "@" + y + "#" + re
    }

    fun1
  }


  def main(args: Array[String]): Unit = {
    println(fun(5))

    //使用一个匿名函数，代替调用该方法时需要传递的 函数参数
    val str = fun1((a: Int, b: Int) => {
      a * b
    }, "hello")
    println(str)

    // 函数的返回是函数
    val function: (String, String) => String = fun(100, 200)
    val strfu: String = function("hello", "world")
    println(strfu)

    println(fun(1, 2)("hello", "scala"))

    //函数的参数和返回都是函数, 使用匿名函数作为函数的参数
    println(fun((a: Int, b: Int) => {
      a + b
    })("hello", "小明"))

  }


}


object keliFunc {

  /**
   * 柯里化函数
   * 柯里化函数就是高阶函数的简化版
   */
  def fun(a: Int, b: Int)(c: Int, d: Int) = {
    a + b + c + d
  }

  def main(args: Array[String]): Unit = {

    println(fun(1, 2)(3,4))
  }


}