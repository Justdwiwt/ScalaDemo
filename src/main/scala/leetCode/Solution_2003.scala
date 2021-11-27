package leetCode

import scala.collection.mutable
import scala.util.control.Breaks._

object Solution_2003 {
  def smallestMissingValueSubtree(parents: Array[Int], nums: Array[Int]): Array[Int] = {
    val graph = mutable.HashMap.empty[Int, mutable.HashSet[Int]]
    parents.zipWithIndex.foreach({ case (x, v) =>
      if (!graph.contains(v)) graph += v -> mutable.HashSet.empty[Int]
      if (!graph.contains(x) && x != -1) graph += x -> mutable.HashSet.empty[Int]
      if (x != -1) graph(x) += v
    })

    val res = Array.fill[Int](nums.length)(1)

    var flag = -1
    breakable {
      while (flag < nums.length - 1) {
        if (nums(flag + 1) != 1) flag += 1 else {
          flag += 1
          break()
        }
      }
    }
    if (flag == -1) return res
    val st = mutable.HashSet.empty[Int]
    val hst = mutable.HashSet.empty[Int]
    var mn = 1

    def f(root: Int): Unit = {
      if (st.contains(root)) return
      st += root
      hst += nums(root)
      graph(root).foreach(ch => if (!st.contains(ch)) f(ch))

    }

    while (flag != -1) {
      f(flag)
      while (hst.contains(mn)) mn += 1
      res(flag) = mn
      flag = parents(flag)
    }

    res
  }
}
