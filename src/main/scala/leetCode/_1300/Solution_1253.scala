package leetCode._1300

import scala.collection.mutable.ArrayBuffer

object Solution_1253 {
  def reconstructMatrix(upper: Int, lower: Int, colsum: Array[Int]): List[List[Int]] = {
    var sum = 0
    var two = 0
    colsum.indices.foreach(i => {
      if (colsum(i) == 2) two += 1
      sum += colsum(i)
    })
    if (sum != upper + lower || math.min(upper, lower) < two)
      return List[List[Int]]()
    var _upper = upper - two
    val res = ArrayBuffer.fill(2)(ArrayBuffer[Int]())
    colsum.indices.foreach(i => if (colsum(i) == 2) {
      res(0) += 1
      res(1) += 1
    } else if (colsum(i) == 1) {
      if (_upper > 0) {
        res(0) += 1
        res(1) += 0
        _upper -= 1
      } else {
        res(0) += 0
        res(1) += 1
      }
    } else {
      res(0) += 0
      res(1) += 0
    })
    res.map(_.toList).toList
  }
}
