package leetCode

object Solution_2471 {
  def minimumOperations(root: TreeNode): Int = {
    def swapTimes(nums: Seq[Int]): Int = {
      @scala.annotation.tailrec
      def find(p: Map[Int, Int])(x: Int): Int =
        if (p(x) == x) x else find(p)(p(x))

      def union(p: Map[Int, Int], t: (Int, Int)): Map[Int, Int] = {
        val (r1, r2) = (find(p)(t._1), find(p)(t._2))
        p + (r1 -> r2)
      }

      val parents = nums.zip(nums.sorted)./:(nums.zip(nums).toMap)(union)

      nums.groupBy(find(parents)).values.map(_.size - 1).sum
    }

    @scala.annotation.tailrec
    def bfs(layer: List[TreeNode], res: Int): Int =
      if (layer == Nil) res
      else {
        val nexts = layer.flatMap(node => List(node.left, node.right).filter(_ != null))
        bfs(nexts, res + swapTimes(layer.map(_.value)))
      }

    bfs(List(root), 0)
  }
}
