package leetCode._2000

object Solution_1992 {
  def findFarmland(land: Array[Array[Int]]): Array[Array[Int]] = {
    var res: List[Array[Int]] = List.empty[Array[Int]]
    land.indices.foreach(i => land.head.indices
      .withFilter(j => land(i)(j) == 1 && (i == 0 || land(i - 1)(j) == 0) && (j == 0 || land(i)(j - 1) == 0))
      .foreach(j => {
        var ri = i
        while (ri + 1 < land.length && land(ri + 1)(j) == 1) ri += 1
        var rj = j
        while (rj + 1 < land(0).length && land(i)(rj + 1) == 1) rj += 1
        res = Array(i, j, ri, rj) :: res
      })
    )
    res.toArray
  }
}
