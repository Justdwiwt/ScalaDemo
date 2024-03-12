package leetCode._1600

object Solution_1530 {

  class TreeNode(_value: Int = 0, _left: TreeNode = null, _right: TreeNode = null) {
    var value: Int = _value
    val left: TreeNode = _left
    val right: TreeNode = _right
  }

  def countPairs(root: TreeNode, distance: Int): Int = {
    var res = 0

    def dfs(root: TreeNode, dis: Int): Array[Int] = {
      val cnt = Array.fill(dis + 1)(0)
      if (root == null) return cnt
      if (root.left == null && root.right == null) {
        cnt(0) = 1
        return cnt
      }
      val l = dfs(root.left, dis)
      val r = dfs(root.right, dis)
      (0 until dis).foreach(i => (0 to (dis - i - 2)).foreach(j => res += (l(i) * r(j))))
      (1 to dis).foreach(i => cnt(i) = l(i - 1) + r(i - 1))
      cnt
    }

    dfs(root, distance)
    res
  }
}
