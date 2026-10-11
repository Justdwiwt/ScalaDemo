package leetCode._4100

object Solution_4015 {
  def weightedSum(parent: Array[Int], nums: Array[Int]): Long = {
    val n = parent.length
    val g = parent.indices.drop(1).foldLeft(Array.fill(n)(List.empty[Int])) { (g, i) =>
      g(parent(i)) = i :: g(parent(i))
      g
    }

    val depth = Array.fill(n)(0)

    def dfs(x: Int): Unit = g(x).foreach { y =>
      depth(y) = depth(x) + 1
      dfs(y)
    }

    dfs(0)

    val h = depth.max + 1

    nums.indices.foldLeft(0L)((sum, i) => sum + nums(i).toLong * (h - depth(i)))
  }
}
