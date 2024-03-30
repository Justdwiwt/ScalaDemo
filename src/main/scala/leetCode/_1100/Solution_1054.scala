package leetCode._1100

import scala.collection.mutable

object Solution_1054 {
  def rearrangeBarcodes(A: Array[Int]): Array[Int] = {
    def f(arr: Array[Int]): List[(Int, Int)] = {
      val m = mutable.HashMap.empty[Int, Int]
      arr.foreach(x => m.put(x, m.getOrElse(x, 0) + 1))
      m.toList.map { case (x, y) => (x, y) }.sortBy(-_._2)
    }

    var l = f(A)
    val arr = Array.fill(l.head._2)(List.empty[Int])
    var t = (0, 0)
    while (l.nonEmpty || t._2 != 0) {
      arr.indices.foreach(i => {
        if (t._2 == 0 && l.nonEmpty) {
          t = l.head
          l = l.tail
        }
        if (t._2 != 0) {
          arr(i) ::= t._1
          t = (t._1, t._2 - 1)
        }
      })
    }
    arr.flatMap(_.reverse)
  }
}
