package com.dtspark.scala.basics

import java.io.IOException


object HelloExceptionAndLazyValue {
  def main(args: Array[String]): Unit = {
    try{
       1/0
    } catch {
      case ioException:IOException => println("IOException: " + ioException.toString())
      case illegalArgs:IllegalArgumentException => println("IllegalArgumentException: " + illegalArgs.toString())
      case arithmeticException:ArithmeticException => println("ArithmeticException: " + arithmeticException.toString())
    } finally {
      //做JVM或者资源释放的工作
    }
    
    lazy val score = 100
    println("....." + score)
    println(".....")
  }
}