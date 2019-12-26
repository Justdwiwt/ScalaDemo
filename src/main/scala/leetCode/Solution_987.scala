package leetCode

import scala.collection.mutable

object Solution_987 {
  def verticalTraversal(root: TreeNode): List[List[Int]] = {
    val m = mutable.HashMap[Int, List[(Int, Int)]]()

    def func(root: TreeNode, key: Int, d: Int): Unit = {
      if (root != null) {
        m.put(key, (root.value, d) :: m.getOrElse(key, Nil))
        func(root.left, key - 1, d + 1)
        func(root.right, key + 1, d + 1)
      }
    }

    func(root, 0, 0)
    m.keySet.toList.sorted.map(key => m(key).sortBy(x => (x._2, x._1)).map(_._1))
  }
}
