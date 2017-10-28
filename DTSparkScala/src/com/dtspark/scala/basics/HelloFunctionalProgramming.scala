package com.dtspark.scala.basics

/**
 * 函数可以被简单的被认为是包裹了一条或者几条语句的代码体，该代码体接收若干参数，经过代码体处理后返回结果，形如数学中的f(x) = x +　１
 * 在Ｓｃａｌａ中函数式一等公民，可以向变量一样被传递，被赋值，同时函数可以赋值给变量，变量也可以赋值给函数，之所以可以是这样，原因在于
 * 函数背后是类和对象，也就是说在运行的时候函数其实是一个变量！！！当然，背后的类是Ｓｃａｌａ语言自动帮助我们生成的，且可以天然的被序列化和
 * 反序列化，这个意义非常重要：
 * 意义１：可以天然的序列化和反序列化的直接好处就是函数可以在分布式系统上传递！！！
 * 意义２：因为函数背后其实是类和对象，所以可以和普通的变量完全一样的应用在任何普通变量可以运用的地方，包括作为参数传递，作为返回值，被变赋值和
 * 		赋值给变量等；
 * 
 * 补充：整个IT编程技术的发展史，其实就是一部封装史:
 * 1，Function时代：在C语言中提供了函数的概念，用函数把若干条语句进行封装和复用；
 * 2，Class时代：在C++和Java等语言中提供了类和兑现个，把数据和处理数据的业务逻辑封装起来；
 * 3，框架时代：把数据、代码和驱动引擎封装起来，是过去10年和未来10年IT技术的核心
 * 
 * 
 * 关于函数初级入门的几个要点：
 * 1，def关键字来定义函数；
 * 2，函数会自动进行类型推断来确定函数返回值的类型，如果函数名称和函数体之间没有等于号的话则类型推断失效，此时函数的类型是Unit
 * 3，函数的参数可以是函数；
 * 4, 如果在函数体中无法推导出函数的类型，则必须声明具体的类型，例如下面的fibonacci；
 * 5, 函数的参数可以有默认值，这样在调用函数的时候如果不想改变默认值的话就直接不传递该参数而是直接使用默认值即可，这在实际的编程中意义重大，尤其
 * 		是在Spark等框架中，因为框架一般都有自己的默认配置和实现，此时我们就可以非常好的使用默认值；
 * 6, 我们可以基于函数的参数的名称来调整函数的传递参数的顺序，重点在于为什么可以这么做呢？原因在于函数背后其实是类，其参数就是类的成员，所以无所谓顺序！
 * 7, 函数中如果不确定传递参数的个数，可以使用变长参数的方式；传参时候的一个方便的语法是: _*
 * 8，可变参数中的数据其实会被收集成为Array数组，我们在入口方面main中其实就是可变参数，是以Array[String]的方式呈现的；
 * 
 */
object HelloFunctionalProgramming {
  def main(args: Array[String]): Unit = {
    hello("Spark", 30)
    println(hello("Spark", 30))  //函数的参数可以是函数
    val result = fibonacci(5)
    println("fibonacci of 100 = " + result)
    
    hello("Scala")
    
    hello(age = 31, name = "dtspark")
    
    println("Sum = " + sum(1,2,3,4,5,6,7,8,9,10))
    println("Sum = " + sum(1 to 100: _*))
    println("sumrecursive = " + sum(1 to 100: _*))
  }
  
  
  def hello(name: String, age: Int = 30) = {
    println("Hello, my name is " + name)
    println("Hello, my age  is " + age)
    age
  }
  
  def fibonacci(n : Int):Int = {
    if(n <= 1) 1
    else fibonacci(n-2) + fibonacci(n-1)
  }
  
  def sum(numbers: Int*) = {
    var result = 0
    for(number <- numbers) result += number
    
    result
  }
  
  def sumrecursive(numbers:Int*):Int = {
    if(0 == numbers.length ) 0
    else numbers.head + sumrecursive(numbers.tail: _*)
    
  }
  
}