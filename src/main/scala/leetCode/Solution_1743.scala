package leetCode

import scala.collection.mutable

object Solution_1743 {
  def restoreArray(adjacentPairs: Array[Array[Int]]): Array[Int] = {
    val m = mutable.HashMap.empty[Int, Int]
    adjacentPairs.foreach(a => {
      m += a.head -> (m.getOrElse(a.head, 0) + 1)
      m += a(1) -> (m.getOrElse(a(1), 0) + 1)
    })

    val diff = mutable.HashMap.empty[Int, Int]
    adjacentPairs.foreach(a => {
      diff += a.head -> (diff.getOrElse(a.head, 0) + a(1))
      diff += a(1) -> (diff.getOrElse(a(1), 0) + a.head)
    })

    val idx = m.keySet.filter(m(_) == 1).head

    val res = Array.fill(adjacentPairs.length + 1)(0)
    res(0) = idx
    res.indices.drop(1).foreach(i => {
      if (i == 1) res(i) = diff(res(i - 1))
      else res(i) = diff(res(i - 1)) - res(i - 2)
    })
    res
  }
}
