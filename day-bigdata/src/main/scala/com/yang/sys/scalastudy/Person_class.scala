package com.yang.sys.scalastudy

// 该类传递了参数，传参就有了默认的构造函数
class Person(xname: Any, xage: Any) {
  //不可变参数，需要在初始化的时候进行赋值，不能使用 person.name 进行赋值
  val name = xname
  val age = xage
  // 可变参数
  var id = 100

  /**
   * 重写构造
   */
  def this(any1: Any, any2: Any, any3: Int) {
    //重写构造的时候，第一行要调用默认的构造方法
    this(any1, any2)
    this.id = any3
  }

  def sayName() = {
    "my name is " + name
  }
}

object Person_class {
  def main(args: Array[String]): Unit = {
    val person = new Person("xiaoming", 180)
    println(person.age);
    println(person.sayName())

    val person1 = new Person("daming", "ss", 100)
    System.out.println(person1.age)
    println(person1.name + "," + person1.age + "," + person1.id)

    // 对象间直接比较的时候，比较的是地址
    val bool = person.equals(person1)
    println(bool)

    // 对象属性的比较，比较的数据
    val boolid = person.id.equals(person1.id)
    println(boolid)
  }

}

class Student{
  private var id = "001"
  private var name = "xiaoming"
  private var age = 18

}

//class叫做这个object的伴生类，object叫做这个class的伴生对象
object Student{
  def main(args: Array[String]): Unit = {
    var student = new Student()
    println(student.age)

  }
}

// class object 不同名，无法访问class 的私有变量
object Teacher{
  def main(args: Array[String]): Unit = {
    var student = new Student()
//    println(student.age)

  }
}


// if
object operateIf{
  def main(args: Array[String]): Unit = {

    val a = 100
    if(a<50) {
      println("a<50")
    }else if (a >= 50 && a <= 100) {
      println("........")
    } else{
      println("a>100")
    }

  }
}


// for
object operateFor{
  def main(args: Array[String]): Unit = {


    for (i <- 1 to (10,2)) {
      for (j <- 1 until (3,2) ) {
        println("i=" + i + " j=" + j)
      }
    }

    println(1 to 10) //Range 1 to 10
    println(1 to(10, 2)) //inexact Range 1 to 10 by 2
    println(1 until(10, 3)) //Range 1 until 10 by 3  不包含10步长为3

  }
}



// 9 * 9
object operate99{
  def main(args: Array[String]): Unit = {

    for(i <- 1 to 9; j <- 1 to 10) {

      if(i>=j){
        print(i +"*"+j +"="+ i*j+" ")
      }
      if(i ==j){
        println()
      }

    }

  }
}



