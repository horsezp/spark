package com.dtspark.scala.basics

object HelloPartialFunction {
  def main(args: Array[String]): Unit = {
     val sample = 1 to 10
    /* val isEven: PartialFunction[Integer, Unit] = {
       case x if x % 2 == 0 => println(x+ " is even")
     }*/
     
     val isEven: PartialFunction[Int, String] = {
      case x if x % 2 == 0 => x+" is even"
     }
     isEven(4)
     
     val evenNumbers = sample collect isEven 
//     evenNumbers.foreach(println )
     
     val isOdd: PartialFunction[Int, String] = {
       case x if x % 2 == 1 => x+" is odd"
     }
     
     val numbers = sample map (isEven orElse isOdd)
     numbers.foreach { println }
     
  }
}