package leetCode

object Solution_200 {
  def numIslands(grid: Array[Array[Char]]): Int = {
    val m = grid.length
    val n = grid.head.length

    case class P(x: Int, y: Int)

    def isGround(p: P): Boolean =
      grid(p.x)(p.y) == '1'

    def adjacentGround(p: P): Set[P] = Set(P(p.x + 1, p.y), P(p.x, p.y + 1), P(p.x - 1, p.y), P(p.x, p.y - 1))
      .filter(pt => pt.x >= 0 && pt.x < m && pt.y >= 0 && pt.y < n)
      .filter(isGround)

    @scala.annotation.tailrec
    def explore(toGo: List[P], acc: Set[P]): Set[P] = toGo match {
      case Nil => acc
      case p :: ps =>
        val as = adjacentGround(p).filter(!acc.contains(_))
        if (as.isEmpty) explore(ps, acc)
        else explore(as.toList ++ toGo, acc ++ as)
    }

    @scala.annotation.tailrec
    def run(i: Int, j: Int, acc: Set[Set[P]]): Set[Set[P]] =
      if (j >= n) run(i + 1, 0, acc)
      else if (i >= m) acc
      else if (isGround(P(i, j)) && !acc.exists(_.contains(P(i, j)))) {
        val p = P(i, j)
        run(i, j + 1, acc + explore(List(p), Set(p)))
      }
      else run(i, j + 1, acc)

    run(0, 0, Set()).size
  }
}
