package com.yang.sys.scalastudy

object String_class {
  def main(args: Array[String]): Unit = {


    /**
     * array
     * ******************************************
     */
    var arr = Array[Int](12, 3, 4, 11, 22, 33)
    //    arr.foreach(println)

    var arrAny = Array[Any](12, "123", 3, 4, 11, 22, 33)
    //    arrAny.foreach(println)

    var arrAdd = new Array[String](3)
    arrAdd(0) = "a"
    arrAdd(1) = "aA"
    arrAdd(2) = "aAbB"
    //    arrAdd.foreach(println)


    // 字符串数组，嵌套字符串数组
    var list = List("hello world", "hello scala", "hello java")
    val re: List[Array[String]] = list.map(s => {
      s.split(" ")
    })
    re.foreach(a => {
      //      println("00000000000")
      //      a.foreach(println)
    })


    // filter 过滤器
    val unit = list.filter(line => {
      !line.equals("hello scala")
    })
    //    unit.foreach(println)


    // set 无序不重复的集合
    var set = Set[Int](1, 2, 2, 1, 3, 4, 5, 3, 4, 5, 6, 7)
    //    set.foreach(println)


    /**
     * map
     * ******************************************
     */
    //初始化方式 1
    var map = Map(65 -> "A", 92 -> "a", "B" -> 66, "b" -> 93)
    map.foreach(m => {
      //      println(m._1 +" is "+m._2)
    })
    val option: Option[Any] = map.get("B")
    //    println(option)

    //通过 map(65) 这种方式获得数据的时候，需要判断 key 值是否存在
    if (map.contains(65)) {
      //简写方式，和下面的写法是一样的
      val option1 = map(65)
      //      val value = map.get(65).get
      println(option1)
    }

    /*val funxy: (Int, Int) => Int = (x: Int, y: Int) => {
      x + y
    }*/

    // key 值不存在，则返回默认值(调用 Function_class 文件中的 object fun1 中的 funxy 方法 )
    val option1 = map.getOrElse(64, fun1.funxy(10, 100))
    // 和上面表达的效果是一样的
    //    val option2 = map.get(64).getOrElse(fun1.funxy(10,100))

    println(option1)

    //初始化方式 2
    val mapVal = Map(97 -> "a", 98 -> "b", (65, "A"), (67, "B"))
    val keys: Iterable[Int] = mapVal.keys
    keys.foreach(e => {
      println(mapVal(e))
    })


  }
}

/**
 * tuple 元组，最多支持 22 个元素
 */
object tuple_class {
  def main(args: Array[String]): Unit = {

    val tuple1 = new Tuple1("hello")
    val tuple2 = new Tuple2("scala", 10)
    // Tuple1 支持 tuple 中存放 1 个元素，Tuple22 支持 tuple 中存储 22 个元素
    val tuple22 = new Tuple22(1, 10, 100, 11, 110, 1, 2, 3, 4, 5, 6, 7, 8, 9, 0, 1, 10, 100, 11, 110, 1, 2)

    val iterator: Iterator[Any] = tuple2.productIterator
    //遍历方式 1
    iterator.foreach(i => { println(i)})
    //遍历方式 2
    while (iterator.hasNext) {
      println(iterator.next())
    }

    //打印元组数据
    println(tuple22)

    //获得元组中某个数据
    println(tuple22._3)

    //Tuple2 支持元组数据位置调换
    println(tuple2)
    //进行位置调换
    println(tuple2.swap)




  }



}