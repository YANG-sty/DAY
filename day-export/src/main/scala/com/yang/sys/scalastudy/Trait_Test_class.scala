package com.yang.sys.scalastudy

/**
 * trait 类似于接口
 */
trait IsEqule {
  def isEqual(p: Any): Boolean

  def isNotEqu(p: Any): Boolean = {
    !isEqual(p)
  }
}

class PointEqule(xx: Int, yy: Int) extends IsEqule {
  val x = xx
  val y = yy

  override def isEqual(p: Any): Boolean = {
    //this 指代的是 A.isEqual(B) 中的 A
    p.isInstanceOf[PointEqule] && p.asInstanceOf[PointEqule].x == this.x
  }
}

object Trait_Test_class {

  def main(args: Array[String]): Unit = {
    val equle1 = new PointEqule(1, 2)
    val equle2 = new PointEqule(1, 3)
    println(equle1.isEqual(equle2))

  }


}
