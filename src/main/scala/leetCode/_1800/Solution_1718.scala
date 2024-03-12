package leetCode._1800

object Solution_1718 {
  def constructDistancedSequence(n: Int): Array[Int] = {
    val res = Array.fill(n * 2 - 1)(0)
    val visited = Array.fill(n + 1)(false)
    backtrack(res, visited, n, 0)
    res
  }

  def backtrack(res: Array[Int], visited: Array[Boolean], n: Int, pos: Int): Boolean = {
    if (pos == res.length) return true
    if (res(pos) != 0) return backtrack(res, visited, n, pos + 1)
    (n to 1 by -1).foreach(i => {
      if (i == 1) {
        if (!visited(i)) {
          res(pos) = i
          visited(i) = true
          if (backtrack(res, visited, n, pos + 1)) return true
          res(pos) = 0
          visited(i) = false
        }
      } else {
        if (!visited(i) && pos + i < res.length && res(pos + i) == 0) {
          res(pos) = i
          res(pos + i) = i
          visited(i) = true
          if (backtrack(res, visited, n, pos + 1)) return true
          res(pos) = 0
          res(pos + i) = 0
          visited(i) = false
        }
      }
    })
    false
  }
}
