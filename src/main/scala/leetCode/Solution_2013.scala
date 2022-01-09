package leetCode

import scala.collection.mutable

object Solution_2013 {
  class DetectSquares() {

    val xMap: mutable.Map[Int, List[Int]] = mutable.Map.empty[Int, List[Int]].withDefaultValue(List.empty)
    val pMap: mutable.Map[(Int, Int), Int] = mutable.Map.empty[(Int, Int), Int].withDefaultValue(0)

    def add(point: Array[Int]): Unit = {
      val x = point(0)
      val y = point(1)
      xMap(x) ::= y
      pMap((x, y)) += 1
    }

    def count(point: Array[Int]): Int = {
      val x = point(0)
      val y = point(1)

      xMap(x).map(p => {
        val diff = p - y
        if (diff == 0) 0
        else pMap((x + diff, y)) * pMap((x + diff, p)) + pMap((x - diff, y)) * pMap((x - diff, p))
      }).sum
    }
  }
}
