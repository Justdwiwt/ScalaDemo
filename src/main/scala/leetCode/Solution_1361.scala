package leetCode

import scala.collection.mutable

object Solution_1361 {
  def validateBinaryTreeNodes(n: Int, leftChild: Array[Int], rightChild: Array[Int]): Boolean = {
    val st = leftChild.filter(_ != -1).toSet ++ rightChild.filter(_ != -1).toSet
    if (st.size != n - 1) false
    else {
      var visited = Set.empty[Int]
      val q = mutable.Queue((0 until n).find(!st.contains(_)).get)
      var res = true
      while (q.nonEmpty && res) {
        val cur = q.dequeue()
        if (visited.contains(cur)) res = false
        else {
          visited += cur
          if (leftChild(cur) != -1) q += leftChild(cur)
          if (rightChild(cur) != -1) q += rightChild(cur)
        }
      }
      res && visited.size == n
    }
  }
}
