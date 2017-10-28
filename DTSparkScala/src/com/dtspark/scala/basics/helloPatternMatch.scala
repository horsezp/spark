package com.dtspark.scala.basics

class DataFrameWork
case class ComputationFramework(name: String, popular:Boolean) extends DataFrameWork
case class StorageFramework(name: String, popular:Boolean) extends DataFrameWork

object helloPatternMatch {
  def main(args: Array[String]): Unit = {
//    getSalary("Scala")
//    getSalary("sllsjsl", 6)
    
//    getMatchType(100.0)
    
//    getMatchCollection(Array("Spark","Python"))
    
//    getBigDataType(ComputationFramework("Spark", true))
//    getBigDataType(ComputationFramework("Spark", false))
//    
//    getBigDataType(StorageFramework("HDFS", true))
    
    getValue("Spark1", Map("Spark" -> "The hottest!", "Hadoop" -> "The olddest"))
  }
  
  
  def getSalary(name: String, age: Int){
    name match{
      case "Spark" => println("$150000/year")
      case "Hadoop" => println("$100000/year")
      case _ if name == "Scala" => println("$140000/year")
      case _ if name == "Hadoop Mapreduce" => println("$90000/year")
      case _name if age >= 5 => println("name: " + _name + " age: " + age + "$120000/year")
      case _ => println("$80000/year")
    }
  }
  
  
  def getMatchType(msg: Any){
    msg match {
      case i : Int => println("Integer")
      case s : String => println("String")
      case d : Double => println("Double")
      case array : Array[Int] => println("Array")
      case _ => println("Unkown type")
    }
  }
  
  def getMatchCollection(msg: Array[String]){
    msg match {
      case Array("Scala") => println("One element")
      case Array("Scala","Java") => println("Two elements")
      case Array("Spark", _*) => println("Many elements begins with Spark")
      case _ => println("Unkown type")
    }
  }
  
  def getBigDataType(data: DataFrameWork){
    data match{
      case ComputationFramework(name, popular) => 
        println("ComputationFramework :" + "name : " + name + " : popular :" + popular)
      case StorageFramework(name, popular) => 
        println("StorageFramework :" + "name : " + name + " : popular :" + popular)
      case _ => println("Some other type")
    }
  }
  
  
  def getValue(key: String, content: Map[String, String]){
    content.get(key) match {
      case Some(value) => println(value) 
      case None => println("Not Found!!!")
    }
  }
  
}