package oop

object Accounts {

  // object标注的为单例对象
  // object与class同名标注的为伴生对象
  private var lastNumber = 0

  def newUniqueNumber(): Int = {
    lastNumber += 1
    lastNumber
  }

}

// 伴生对象
// 类和它的伴生对象可以相互访问私有特性
// 必须存在与用一个源文件中
// 类的伴生对象的功能特性并不在类的作用域内
// 例如：Accounts类必须通过Accounts.newUniqueNumber()而不是直接用newUniqueNumber()来调用伴生对象
class Accounts {

  val id: Int = Accounts.newUniqueNumber()
  private var balance = 0.0

  def deposit(amount: Double) {
    balance += amount
  }

}
