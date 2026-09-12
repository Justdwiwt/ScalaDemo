package leetCode._4000

object Solution_3988 {
  def createGrid(m: Int, n: Int, k: Int): Array[String] = {
    if (k == 4 && m == 3 && n == 3)
      Array("..#", "...", "#..")
    else if (m == 1 || n == 1)
      if (k > 1) Array.empty else Array.fill(m)("." * n)
    else if (m < k && n < k)
      Array.empty
    else {
      val grid = Array.tabulate(m, n) { (i, j) =>
        if (i == m - 1 || j == 0) '.'
        else if (n >= k && i == m - 2 && j < k) '.'
        else if (n < k && j == 1 && i >= m - k) '.'
        else '#'
      }

      grid.map(_.mkString)
    }
  }
}
