package leetCode._800

import scala.collection.mutable

object Solution_753 {
  def crackSafe(n: Int, k: Int): String = {
    val t = k
    val M = math.pow(10, n - 1).toInt
    val st = mutable.HashSet.empty[Int]
    val res = new mutable.StringBuilder

    def f(node: Int): Unit = {
      (0 until t).foreach(i => {
        val nei = node * 10 + i
        if (!st.contains(nei)) {
          st += nei
          f(nei % M)
          res.append(i)
        }
      })
    }

    f(0)
    (1 until n).foreach(_ => res.append('0'))
    res.mkString
  }
}
