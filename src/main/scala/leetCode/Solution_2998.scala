package leetCode

import scala.collection.mutable

object Solution_2998 {
  def minimumOperationsToMakeEqual(x: Int, y: Int): Int = {
    val diff = Array(Array(1, 1), Array(1, -1), Array(5, 0), Array(11, 0))
    val arr = Array.fill(10005)(-1)
    arr(y) = 0
    val q = mutable.Queue.empty[Int]
    q += y
    while (q.nonEmpty) {
      val a = q.head
      q.dequeue
      diff.foreach(m => {
        val d = a * m.head + m(1)
        if (d >= 0 && d < 10005 && arr(d) == -1) {
          arr(d) = arr(a) + 1
          q += d
        }
      })
    }
    arr(x)
  }
}
