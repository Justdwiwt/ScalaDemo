package leetCode._1800

object Solution_1718 {
  def constructDistancedSequence(n: Int): Array[Int] = {
    val res = Array.fill(n * 2 - 1)(0)
    val visited = Array.fill(n + 1)(false)

    def backtrack(pos: Int): Boolean =
      if (pos == res.length) true
      else if (res(pos) != 0) backtrack(pos + 1)
      else (n to 1 by -1).exists(i => {
        if (!visited(i) && (i == 1 || (pos + i < res.length && res(pos + i) == 0))) {
          res(pos) = i
          if (i > 1) res(pos + i) = i
          visited(i) = true
          if (backtrack(pos + 1)) true
          else {
            res(pos) = 0
            if (i > 1) res(pos + i) = 0
            visited(i) = false
            false
          }
        } else false
      })

    if (backtrack(0)) res else Array.empty
  }
}
