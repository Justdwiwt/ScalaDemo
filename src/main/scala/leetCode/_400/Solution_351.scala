package leetCode._400

object Solution_351 {
  def numberOfPatterns(m: Int, n: Int): Int = {
    var res = 0

    def f(idx: Int, visited: Array[Boolean], steps: Int): Unit = {
      val st = steps - 1
      if (st == 0) res += 1
      else {
        visited(idx) = true
        (0 until 9).foreach(i => if (g(i, idx, visited)) f(i, visited, st))
        visited(idx) = false
      }
    }

    def g(idx: Int, pre: Int, visited: Array[Boolean]): Boolean = {
      if (visited(idx)) return false
      if ((idx + pre != 8) && ((idx + pre) % 2 == 1 || (idx % 3 != pre % 3 && idx / 3 != pre / 3))) return true
      visited((idx + pre) / 2)
    }

    (0 until 9).foreach(i => (m to n).foreach(j => f(i, Array.fill(9)(false), j)))
    res
  }
}
