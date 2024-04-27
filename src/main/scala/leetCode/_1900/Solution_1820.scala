package leetCode._1900

object Solution_1820 {
  def maximumInvitations(grid: Array[Array[Int]]): Int = {
    val n = grid.head.length
    val vis = Array.fill(n)(false)
    val p = Array.fill(n)(-1)

    def check(i: Int): Boolean = {
      val foundMatch = grid.head.indices.exists(j => {
        if (grid(i)(j) == 1 && !vis(j)) {
          vis(j) = true
          if (p(j) == -1 || check(p(j))) {
            p(j) = i
            true
          } else false
        } else false
      })
      foundMatch
    }

    val cnt = grid.indices.count(i => {
      java.util.Arrays.fill(vis, false)
      check(i)
    })
    cnt
  }
}
