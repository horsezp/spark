package com.leo.practise

import scala.collection.mutable.ArrayBuffer

object ArrayTest {

  def main(args: Array[String]): Unit = {
    val a = Array(1, 2, 3, 4, 5)
    for (sub <- a) println("test:" + sub)

    val array2 = ArrayBuffer[Int]()
    array2 += 12
    array2 += (1, 2, 3)
    for (sub <- array2) println("test:" + sub)

    println(array2.filter { x => x % 2 == 0 }.mkString(" "));

    println(array2.filter { x => x % 2 == 0 }.map { _ * 10 }.mkString("  "));
  }
}