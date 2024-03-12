package leetCode._1800

object Solution_1765 {
  //noinspection RemoveRedundantReturn
  @scala.annotation.tailrec
  def f(isWater: Array[Array[Int]], toVisit: Array[(Int, Int)], visited: Set[(Int, Int)], xMax: Int, yMax: Int): Unit = {
    if (toVisit.isEmpty) return
    else {
      val neighbours = toVisit.flatMap({ case (x, y) =>
        val neighbourList = List((x + 1, y), (x - 1, y), (x, y - 1), (x, y + 1))
          .filter({ case (x, y) => x >= 0 && y >= 0 && x <= xMax && y <= yMax && isWater(x)(y) < 0 })
        neighbourList.foreach({ case (n, m) => if (isWater(n)(m) < 0) isWater(n)(m) = isWater(x)(y) + 1 })
        neighbourList
      }).distinct
      f(isWater, neighbours, visited ++ toVisit, xMax, yMax)
    }
  }

  def highestPeak(isWater: Array[Array[Int]]): Array[Array[Int]] = {
    val xMax = isWater.length - 1
    val yMax = isWater.head.length - 1
    val startPos = (0 to xMax).flatMap(x => (0 to yMax).map(y => (x, y))).filter({ case (x, y) => isWater(x)(y) == 1 }).toArray
    (0 to xMax).flatMap(x => (0 to yMax).map(y => (x, y))).foreach({ case (x, y) => if (isWater(x)(y) == 1) isWater(x)(y) = 0 else isWater(x)(y) = -1 })
    f(isWater, startPos, Set.empty, xMax, yMax)
    isWater
  }
}
