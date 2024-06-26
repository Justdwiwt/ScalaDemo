package leetCode._2000

// fixme: case 64/66 timeout
object Solution_1916 {
  val M = 1000000007

  def waysToBuildRooms(prevRoom: Array[Int]): Int = {
    val n = prevRoom.length
    val adj = Array.fill(n)(List[Int]())

    prevRoom.indices.drop(1).foreach(i => adj(prevRoom(i)) = i :: adj(prevRoom(i)))

    def comb(n: Int, k: Int): Long = {
      if (k > n) return 0
      var num = 1L
      var denom = 1L
      (0 until k).foreach(i => {
        num = num * (n - i) % M
        denom = denom * (i + 1) % M
      })
      num * powMod(denom, M - 2) % M
    }

    def powMod(x: Long, y: Long): Long = {
      if (y == 0) return 1
      val p = powMod(x, y / 2) % M
      if (y % 2 == 0) p * p % M else p * p % M * x % M
    }

    def dfs(node: Int): (Int, Long) = {
      val stack = scala.collection.mutable.Stack[(Int, Int)]()
      val size = Array.fill(n)(0)
      val dp = Array.fill(n)(1L)
      stack.push((node, 0))

      while (stack.nonEmpty) {
        val (u, state) = stack.pop()
        if (state == 0) {
          size(u) = 1
          dp(u) = 1L
          stack.push((u, 1))
          adj(u).foreach(v => stack.push((v, 0)))
        } else adj(u).foreach(v => {
          size(u) += size(v)
          dp(u) = (dp(u) * dp(v) % M * comb(size(u) - 1, size(v)) % M) % M
        })
      }
      (size(node), dp(node))
    }

    dfs(0)._2.toInt
  }
}
