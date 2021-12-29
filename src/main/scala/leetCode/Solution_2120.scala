package leetCode

object Solution_2120 {
  def executeInstructions(n: Int, startPos: Array[Int], s: String): Array[Int] = {
    def dfs(s: String, i: Int): Int = {
      var res = 0
      val pos = Array[Int](startPos.head, startPos(1))
      (i until s.length).foreach(j => {
        s(j) match {
          case 'L' => pos(1) -= 1
          case 'R' => pos(1) += 1
          case 'U' => pos(0) -= 1
          case 'D' => pos(0) += 1
        }
        if (pos.head < 0 || pos(1) == n || pos.head == n || pos(1) < 0)
          return res
        res += 1
      })
      res
    }

    val res = Array.fill(s.length)(0)
    s.indices.foreach(i => res(i) = dfs(s, i))
    res
  }
}
