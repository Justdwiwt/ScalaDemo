package leetCode

import scala.collection.mutable

object Solution_531 {
  def findLonelyPixel(picture: Array[Array[Char]]): Int = {
    var row = mutable.HashMap.empty[Int, Int]
    var col = mutable.HashMap.empty[Int, Int]
    picture.indices.foreach(i => picture.head.indices.foreach(j => if (picture(i)(j) == 'B') {
      row += i -> (row.getOrElse(i, 0) + 1)
      col += j -> (col.getOrElse(j, 0) + 1)
    }))
    var res = 0
    picture.indices.foreach(i => picture.head.indices.foreach(j => if (picture(i)(j) == 'B' && row(i) == 1 && col(j) == 1) res += 1))
    res
  }
}
