package leetCode

import scala.collection.mutable

object Solution_894 {

  private val m = new mutable.HashMap[Int, List[TreeNode]]()

  def allPossibleFBT(N: Int): List[TreeNode] = {
    if (N % 2 == 0) return List.empty
    if (N == 1) return List(new TreeNode(0))
    if (m.contains(N)) return m(N)
    var res = List[TreeNode]()
    (1 until N by 2).foreach(i => {
      val left = allPossibleFBT(i)
      val right = allPossibleFBT(N - i - 1)
      left.foreach(i => right.foreach(j => {
        var cur = new TreeNode(0)
        cur.left = i
        cur.right = j
        res :+= cur
      }))
    })
    res
  }

}
