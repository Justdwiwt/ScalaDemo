package leetCode._1800

import scala.collection.mutable

object Solution_1719 {
  def checkWays(pairs: Array[Array[Int]]): Int = {
    val freq = mutable.HashMap.empty[Int, mutable.HashSet[Int]]
    pairs.foreach(p => {
      freq.getOrElseUpdate(p.head, mutable.HashSet.empty)
      freq(p.head).add(p(1))
      freq.getOrElseUpdate(p(1), mutable.HashSet.empty)
      freq(p(1)).add(p.head)
    })
    solve(mutable.HashSet.empty, freq.keySet.toSet, freq)
  }

  def solve(parents: mutable.HashSet[Int], currNodes: Set[Int], freq: mutable.HashMap[Int, mutable.HashSet[Int]]): Int = {
    var res = 1
    var root = -1
    currNodes.foreach(cur => {
      if (freq(cur).size == parents.size + currNodes.size - 1) {
        if (root != -1) res = 2
        root = cur
      }
      if (freq(cur).size >= parents.size + currNodes.size) return 0
    })
    if (root == -1) return 0
    freq(root).foreach(n => if (!parents.contains(n) && !currNodes.contains(n)) return 0)
    val newParents = mutable.HashSet.empty[Int]
    parents.foreach(newParents.add)
    newParents.add(root)
    val c = mutable.HashSet.empty[Int]
    currNodes.foreach(c.add)
    c.remove(root)
    while (c.nonEmpty) {
      var child = -1
      var degree = 0
      c.foreach(n => if (freq(n).size > degree) {
        child = n
        degree = freq(n).size
      })
      val node = mutable.HashSet.empty[Int]
      c.foreach(n => if (n == child || freq(n).contains(n)) node.add(n))
      node.foreach(n => c.remove(n))
      val a = solve(newParents, node.toSet, freq)
      if (a == 0) return 0
      if (a == 2) res = 2
    }
    res
  }
}
