package com.dtspark.scala.basics

class Man(val name: String)
/*object Man{
  implicit def man2SuperMan(man: Man) = new SuperMan(man.name)
}*/
class SuperMan(val name: String){
  def makeMiracles = println(this.name + " Wow,wow,wow...")
}
object implicts{
  implicit def man2SuperMan(man: Man) = new SuperMan(man.name)
}
object HelloImplicits {
  def main(args: Array[String]): Unit = {
    import com.dtspark.scala.basics.implicts._
    val man = new Man("Scala")
    man.makeMiracles
    
    implicit val content = "Dollar"
    
    talk("Scala")
    
  }
  
  def talk(name: String)(implicit content:String) = println(name + " : " +content)
}