package leetCode._3700

object Solution_3668 {
  def recoverOrder(order: Array[Int], friends: Array[Int]): Array[Int] = {
    val set = friends.toSet
    order.filter(set(_))
  }
}
