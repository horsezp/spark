package com.dtspark.scala.basics

trait Logger{
  def log(message: String){
    println("Logger: " + message)
  }
}

trait RichLogger extends Logger{
  override def log(message: String){
    println("RichLogger: " + message)
  }
}

class Loggin(val name: String) extends Logger{
  def loggin{
    println("Hi, welcome ! " + name)
    log(name)
  }
}

trait Information{
  def getInformation: String
  def checkIn: Boolean = {
    getInformation.equals("Spark")
  }
}


class Passenger(val name: String) extends Information{
  def getInformation = name
}


object HelloTrait {
  def main(args: Array[String]): Unit = {
    val personLoggin = new Loggin("DTSpark") with RichLogger
    personLoggin.loggin
  }
}