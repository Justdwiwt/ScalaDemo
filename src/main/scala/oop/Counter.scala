package oop

import java.time.Instant

import scala.beans.BeanProperty

class Counter {

  private var value = 0

  // val定义只读属性，只有get没有set
  val timeStamp: Instant = java.time.Instant.now()

  // get/set
  private[this] var _age: Int = 0

  def age: Int = _age

  def age_=(value: Int): Unit = {
    _age = value
  }

  def increment(): Unit = {
    value += 1
  }

  def current(): Int = value

  val myCounter = new Counter
  myCounter.increment()
  println(myCounter.current())

  class Person {

    // 注解标注，自动生成方法
    // name: String
    // name_=(newValue: String): Unit
    // getName(): String
    // setName(newValue: String): Unit
    @BeanProperty var name: String = _

    private var addr = ""
    private var age = 0

    // 辅助构造器
    def this(addr: String) {
      this()
      this.addr = addr
    }

    // 辅助构造器
    def this(addr: String, age: Int) {
      this(addr)
      this.age = age
    }

    override def toString = s"Person($name, $addr, $age)"

  }

  // 主构造器参数写在类名后
  class Student(val name: String, val age: Int) {

    // 主构造器参数
    def description = s"$name is $age years old"

    override def toString = s"Student($name, $age, $description)"

  }

}
