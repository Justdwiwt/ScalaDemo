package oop

class Employee(val name: String) extends Counter {

  val salary = 0.0

  override def toString = s"Employee($salary)"

  // 匿名子类
  val alien: Employee = new Employee("Ken") {

    def greeting = "Ken"

  }

  // 结构类型的对象
  def meet(e: Employee {def greeting: String}): Unit = {

    println(s"${e.name} says: ${e.greeting}")

  }

}
