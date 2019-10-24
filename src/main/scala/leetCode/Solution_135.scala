package leetCode

import java.util

object Solution_135 {
  def candy(ratings: Array[Int]): Int = {
    val res = new Array[Int](ratings.length)
    util.Arrays.fill(res, 1)
    var sum = 0
    (1 until ratings.length).foreach(i => if (ratings(i) > ratings(i - 1)) res(i) = res(i - 1) + 1)
    (ratings.length - 2 to 0 by (-1)).foreach(i => if (ratings(i) > ratings(i + 1)) res(i) = math.max(res(i), res(i + 1) + 1))
    res.indices.foreach(i => sum += res(i))
    sum
  }
}
