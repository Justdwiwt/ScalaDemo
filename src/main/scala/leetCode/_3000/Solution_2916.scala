package leetCode._3000

import scala.collection.mutable

object Solution_2916 {
  private var sum: Array[Long] = _
  private var todo: Array[Int] = _

  def sumCounts(nums: Array[Int]): Int = {
    val n = nums.length
    sum = new Array[Long](n * 4)
    todo = new Array[Int](n * 4)

    var res = 0L
    var s = 0L
    val last = mutable.HashMap.empty[Int, Int]
    (1 to n).foreach(i => {
      val x = nums(i - 1)
      val j = last.getOrElseUpdate(x, 0)
      s += queryAndAdd1(1, 1, n, j + 1, i) * 2 + i - j
      res = (res + s) % 1000000007
      last.update(x, i)
    })
    res.toInt
  }

  private def f(o: Int, l: Int, r: Int, add: Int): Unit = {
    sum(o) += add.toLong * (r - l + 1)
    todo(o) += add
  }

  private def queryAndAdd1(o: Int, l: Int, r: Int, L: Int, R: Int): Long = {
    if (L <= l && r <= R) {
      val res = sum(o)
      f(o, l, r, 1)
      res
    } else {
      val m = (l + r) / 2
      val add = todo(o)
      if (add != 0) {
        f(o * 2, l, m, add)
        f(o * 2 + 1, m + 1, r, add)
        todo(o) = 0
      }

      var res = 0L
      if (L <= m) res += queryAndAdd1(o * 2, l, m, L, R)
      if (m < R) res += queryAndAdd1(o * 2 + 1, m + 1, r, L, R)
      sum(o) = sum(o * 2) + sum(o * 2 + 1)
      res
    }
  }
}
