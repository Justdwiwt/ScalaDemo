package leetCode._1900

import scala.collection.mutable

object Solution_1878 {
  val N: Int = 110
  val s1: Array[Array[Int]] = Array.fill(N, N)(0)
  val s2: Array[Array[Int]] = Array.fill(N, N)(0)

  def getBiggestThree(g: Array[Array[Int]]): Array[Int] = {
    val n = g.length
    val m = g.head.length

    (1 to n).foreach(i => (1 to m).foreach(j => {
      s1(i)(j) = s1(i - 1)(j - 1) + g(i - 1)(j - 1)
      s2(i)(j) = s2(i - 1)(j + 1) + g(i - 1)(j - 1)
    }))

    val ts = mutable.TreeSet.empty[Int]
    (1 to n).foreach(i => (1 to m).foreach(j => {
      ts.add(g(i - 1)(j - 1))
      (1 to (i - 1).min(n - i).min((j - 1).min(m - j))).foreach(k => {
        val a = s2(i)(j - k) - s2(i - k)(j)
        val b = s1(i)(j + k) - s1(i - k)(j)
        val c = s2(i + k)(j) - s2(i)(j + k)
        val d = s1(i + k)(j) - s1(i)(j - k)
        ts.add(a + b + c + d - g(i + k - 1)(j - 1) + g(i - k - 1)(j - 1))
      })
      while (ts.size > 3) ts.remove(ts.min)
    }))

    ts.toArray.reverse
  }
}
