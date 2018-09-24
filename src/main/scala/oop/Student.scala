package oop

class Student(name: String) extends Person(name) {

  // 子类重写父类中的抽象方法时，不需要使用override
  def id: Int = name.hashCode

  // 同方法一样，不需要使用override
  val age: Int = 5
  var address: String = _

  val fred: Person = new Person(name) {
    override val age: Int = 123
    override var address: String = "address"

    override def id: Int = address.hashCode
  }

}
