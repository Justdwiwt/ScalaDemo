package leetCode._1800

import scala.collection.mutable.ListBuffer

object Solution_1762 {
  def findBuildings(heights: Array[Int]): Array[Int] = {
    val res = ListBuffer[Int]()
    var maxRightHeight = Int.MinValue
    heights.indices.reverse.foreach(i => if (heights(i) > maxRightHeight) {
      res.prepend(i)
      maxRightHeight = heights(i)
    })
    res.toArray
  }
}
