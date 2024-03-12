package leetCode._100

object Solution_51 {
  def solveNQueens(n: Int): List[List[String]] = func(n)

  def func(n: Int): List[List[String]] = {
    var res = List[List[String]]()
    (0 until n).permutations.foreach(x => if (valid(x.toList)) {
      val candidate = Array.ofDim[String](n, n)
      (0 until n).foreach(xx => (0 until n).foreach(yy =>
        if (x(xx) == yy) candidate(xx)(yy) = "Q" else candidate(xx)(yy) = "."))
      res = (0 until n).map(x => candidate(x).reduce(_ + _)).toList :: res
    })
    res
  }

  def valid(l: List[Int]): Boolean = {
    l.indices.foreach(x => (x + 1 until l.length).foreach(y => if (((x - y).toDouble / (l(x) - l(y)).toDouble).abs == 1) return false))
    true
  }
}
