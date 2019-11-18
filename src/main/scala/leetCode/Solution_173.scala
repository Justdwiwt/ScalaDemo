package leetCode

import scala.collection.mutable

object Solution_173 {

  class BSTIterator(_root: TreeNode) {
    private val st = new mutable.Stack[TreeNode]()
    private var root = _root

    while (root != null) {
      st.push(root)
      root = root.left
    }

    /** @return the next smallest number */
    def next(): Int = {
      var n = st.top
      st.pop()
      val res = n.value
      if (n.right != null)
        n = n.right
      while (n != null) {
        st.push(n)
        n = n.left
      }
      res
    }

    /** @return whether we have a next smallest number */
    def hasNext(): Boolean = {
      st.nonEmpty
    }

  }

}
