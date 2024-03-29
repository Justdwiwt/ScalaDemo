package leetCode._1200

import scala.collection.mutable

object Solution_1162 {
  def maxDistance(grid: Array[Array[Int]]): Int = {

    def isValidWaterCell(pos: (Int, Int)): Boolean =
      pos._1 >= 0 && pos._1 < grid.length && pos._2 >= 0 && pos._2 < grid.length && grid(pos._1)(pos._2) == 0

    def isByWater(pos: (Int, Int)): Boolean =
      Array((pos._1 + 1, pos._2), (pos._1 - 1, pos._2), (pos._1, pos._2 + 1), (pos._1, pos._2 - 1))
        .exists(isValidWaterCell)

    val landCellsByWater = mutable.ArrayBuffer.empty[(Int, Int)]

    grid.indices.foreach(row => grid.indices.foreach(col =>
      if (grid(row)(col) == 1 && isByWater((row, col)))
        landCellsByWater += ((row, col))))

    @scala.annotation.tailrec
    def findFurthestWater(currCells: mutable.HashSet[(Int, Int)], seen: mutable.HashSet[(Int, Int)], steps: Int): Int =
      if (currCells.nonEmpty) {
        val nextFurtherWaterCells = currCells.flatMap(pos =>
          Array((pos._1 + 1, pos._2), (pos._1 - 1, pos._2), (pos._1, pos._2 + 1), (pos._1, pos._2 - 1))
            .filter(cell => isValidWaterCell(cell) && !seen.contains(cell)))
        seen ++= nextFurtherWaterCells
        findFurthestWater(nextFurtherWaterCells, seen, steps + 1)
      } else steps - 1

    findFurthestWater(mutable.HashSet() ++ landCellsByWater, mutable.HashSet() ++ landCellsByWater, 0)
  }
}
