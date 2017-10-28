package com.dtspark.scala.basics

@DTCoder(name = "Scala", salary = 15000)  case class Person1(name: String, age: Int)

class DTCoder(val name: String, val salary: Int) extends annotation.Annotation
object DTCoder{
  def apply(name: String, salary:Int) = {
    println("DTCoder apply methode invoked !!!")
    new DTCoder(name, salary)
  }
  
  /*def unapply(information: String) = {
    Some((information.substring(0, information.indexOf(" ")), information.substring(information.indexOf(" ") + 1)))
  }*/
  
  def unapply(information: DTCoder) = {
    Some((information.name, information.salary))
  }
  
}

object HelloExtractor extends App {
  val person = Person1.apply("Spark",6)  //调用apply工厂构造方法构造出类的实例对象
  val Person1(name, age) = person //调用unapply方法把person实例中的name和age提取出来并赋值给Person1
  println(name + " : " + age)
  
  person match {
    case Person1(name, age) => println("Wow " + name + " : " + age)
  }
  
  
  val dtcoder = DTCoder("Hadoop", 200000)
  val DTCoder(dtname, salary) = dtcoder
  
//  val DTCoder(dtname, salary) = "Spark 1000000"
  
}