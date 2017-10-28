package com.dtspark.scala.basics

abstract class Person {
  val counter:Int
  val counterArray = new Array[Int](counter)
}

class Sporter extends Person{
  override val counter = 5
  
  
}

class Programmer(val name : String, val salary: Double){
  
  final override def equals(other: Any) = {
    val that = other.asInstanceOf[Programmer]
    if (that == null) false
    else name == that.name && salary == that.salary
  }
  
  final override def hashCode = name.hashCode() * 17 + salary.hashCode() * 9
  
}

/*class Sporter extends {
  override val counter = 5
} with Person*/

object OverrideField extends App{
  
  val s = new Sporter
  println(s.counterArray.length)
}