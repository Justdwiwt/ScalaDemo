package leetCode

import scala.collection.mutable

object Solution_501 {
  def findMode(root: TreeNode): Array[Int] = root match {
    case null => Array.empty
    case _ =>
      var res = Array.empty[Int]
      var p = root
      var pre: TreeNode = null
      val st = new mutable.Stack[TreeNode]()
      var mx = 0
      var cnt = 1
      while (st.nonEmpty || p != null) {
        while (p != null) {
          st.push(p)
          p = p.left
        }
        p = st.top
        st.pop
        if (pre != null) cnt = if (p.value == pre.value) cnt + 1 else 1
        if (cnt >= mx) {
          if (cnt > mx) res = Array.empty
          res :+= p.value
          mx = cnt
        }
        pre = p
        p = p.right
      }
      res
  }
}
