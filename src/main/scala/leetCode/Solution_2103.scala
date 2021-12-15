package leetCode

import scala.collection.mutable

object Solution_2103 {
  def countPoints(rings: String): Int = {
    val arr = Array.fill(10)(mutable.Set.empty[Char])
    (0 until rings.length by 2).foreach(i => {
      val color = rings(i)
      val rod = rings(i + 1) - '0'
      arr(rod) += color
    })
    arr.count(_.size == 3)
  }
}
