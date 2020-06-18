package leetCode

import scala.collection.mutable

object Solution_1028 {
  def recoverFromPreorder(S: String): TreeNode = {
    var p = 0
    var cur = 0
    val st = new mutable.Stack[(TreeNode, Int)]
    var i = 0
    while (i < S.length) {
      if (S(i) != '-') {
        while (i < S.length && S(i) != '-') {
          cur = (cur) * 10 + (S(i) - '0')
          i += 1
        }
        val node = new TreeNode(cur)
        while (st.nonEmpty && p <= st.top._2) st.pop()
        if (st.nonEmpty && (if (st.top._1.left == null) true else false)) st.top._1.left = node
        else if (st.nonEmpty && (if (st.top._1.right == null) true else false)) st.top._1.right = node
        st.push((node, p))
        p = 0
        cur = 0
      } else {
        p += 1
        i += 1
      }
    }
    while (st.length > 1) st.pop()
    st.top._1
  }
}
