package leetCode._400

import scala.collection.mutable.ListBuffer

object Solution_386 {
  def lexicalOrder(n: Int): List[Int] = {
    val res = ListBuffer.empty[Int]

    def f(s: Int): Unit = {
      res += s
      (10 * s to n.min(10 * s + 9)).foreach(f)
    }

    (1 to n.min(9)).foreach(f)
    res.toList
  }
}
