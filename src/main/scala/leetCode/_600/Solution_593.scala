package leetCode._600

import scala.collection.mutable

object Solution_593 {
  def validSquare(p1: Array[Int], p2: Array[Int], p3: Array[Int], p4: Array[Int]): Boolean = {
    val s = mutable.HashSet.empty[Int]
    s += f(p1, p2)
    s += f(p1, p3)
    s += f(p1, p4)
    s += f(p2, p3)
    s += f(p2, p4)
    s += f(p3, p4)
    s.size == 2 && !s.contains(0)
  }

  def f(a: Array[Int], b: Array[Int]): Int =
    (a.head - b.head) * (a.head - b.head) + (a(1) - b(1)) * (a(1) - b(1))
}
