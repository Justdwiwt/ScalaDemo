package leetCode._500

object Solution_498 {
  private case class Pos(i: Int, j: Int, diff: Int)

  def findDiagonalOrder(mat: Array[Array[Int]]): Array[Int] = {
    val n = mat.head.length

    val diags = mat.indices.flatMap(i => mat(i).indices.map(j => Pos(i, j, n - i - j) -> mat(i)(j)))

    val positionList: List[List[Pos]] = diags
      .groupBy { case (Pos(_, _, d), _) => d }
      .toList
      .sortBy { case (d, _) => -d }
      .map { case (_, l) => l.toList.map { case (p, _) => p } }


    positionList.zipWithIndex.flatMap {
      case (l, i) if i % 2 == 0 => l.sortBy { case Pos(_, j, _) => j }.map(p => mat(p.i)(p.j))
      case (l, _) => l.sortBy { case Pos(_, j, _) => -j }.map(p => mat(p.i)(p.j))
    }.toArray
  }
}
