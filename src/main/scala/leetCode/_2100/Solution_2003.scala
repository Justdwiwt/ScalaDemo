package leetCode._2100

object Solution_2003 {
  def smallestMissingValueSubtree(parents: Array[Int], nums: Array[Int]): Array[Int] = {
    val oneIdx = nums.indexWhere(_ == 1)
    if (oneIdx == -1) return Array.fill(nums.length)(1)
    val graph = parents.zipWithIndex.groupBy(_._1).mapValues(_.map(_._2).distinct)
    val seen = Array.fill(nums.max + 2)(false)
    var node = oneIdx
    var cur = 1
    val res = Array.fill(nums.length)(1)

    def dfs(node: Int): Unit = {
      if (!seen(nums(node))) {
        seen(nums(node)) = true
        graph.get(node).foreach(_.foreach(dfs))
      }
    }

    while (node != -1) {
      dfs(node)
      while (seen(cur)) cur += 1
      res(node) = cur
      node = parents(node)
    }
    res
  }
}
