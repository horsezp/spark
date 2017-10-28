package com.dtspark.scala.basics
/**
 * 1,默认情况下Map构造的是不可变的集合，里面的内容不可修改，一旦修改就变成新的Map，原有的Map内容保持不变；
 * 2，Map的实例是调用工厂方法模式apply来构造Map实例，而需要主要的是Map是接口，在apply中使用了具体的实现；
 * 3,如果想直接new出Map实例，则需要使用HashMap等具体的Map子类；
 * 4,查询一个Map中的的值一定是采用getOrElse的语法的，一方面是在key不存的情况下不报告异常，另外还有一个神奇的作用就是提供默认值
 * 		而关于默认值的提供在实际开发中至关重要，在Spark中很多默认的配置都是通过getOrElse的方式来实现的；
 * 5,使用SortedMap可以得到排序的Map集合；
 * 6，LinkedHashMap可以记住插入的数据的顺序，这在实际开发中非常有用
 * 
 * 
 * 7,Tuple中可以有很多不同类型的数据，例如("wangjialin", "male",30, "I am into spark so much!!!")
 * 8,在企业级实际开发大数据的时候一定会反复的使用Tuple来表达数据结构，以及使用Tuple来处理业务逻辑
 * 9，Tuple的另外一个非常重要的使用是作为函数的返回值，在Tuple中返回若干个值，以SparkContext源码为例来说明
 * 		// Create and start the scheduler
 *   val (sched, ts) = SparkContext.createTaskScheduler(this, master)
 *   _schedulerBackend = sched
 *   _taskScheduler = ts
 */
object HelloMapTuple {
  def main(args: Array[String]): Unit = {
    
    val bigDatas = Map("Spark"->6, "Hadoop"->11)  //调用工厂方法模式apply来构造Map实例，而需要主要的是Map是接口，在apply中使用了具体的实现
    val persons = scala.collection.immutable.SortedMap(("jialingege", 30),("dtspark", 1),("hadoop",11))
    
    val programingLanguage = scala.collection.mutable.Map("Scala" -> 13, "Java"-> 23)
    programingLanguage("Scala") = 15
    
    for((name,age) <-programingLanguage) println(name + " : " + age)
    println(programingLanguage.getOrElse("Python", "jialingege"))
    
    
    
    val personsInformation = new scala.collection.mutable.LinkedHashMap[String, Int]
    
    personsInformation += ("Scala" -> 13, "java"-> 23, "python" -> 10)
//    personsInformation -=("Java")
    for((name,age) <-personsInformation) println(name + " : " + age)
    for(key <- personsInformation.keySet) println(key)
    for(value <- personsInformation.values) println(value)
    
//    val result = for((name,age) <-personsInformation) yield (age, name)
//    for((age,name) <-result) println(age + " : " + name)
    
     for((name,age) <-persons) println(name + " : " + age)
     
     
     val information = ("wangjialin", "male",30, "I am into spark so much!!!")
     println(information._4)
    
    
  }
}