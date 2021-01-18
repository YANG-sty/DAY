package com.yang.sys.scalastudy

trait Speak {
  def speak(name: String) = {
    println(name + " is speaking.....")
  }

}

trait Listen {
  def listen(name: String) = {
    println(name + " is LISTENING*****")
  }
}

class PersonSL() extends Speak with Listen{

}

object Trait_class{
  def main(args: Array[String]): Unit = {
    val person = new PersonSL()
    person.speak("zhang三")
    person.listen("li四")
  }
}
