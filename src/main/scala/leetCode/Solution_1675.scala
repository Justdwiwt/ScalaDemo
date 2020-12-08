package leetCode

import scala.collection.mutable

object Solution_1675 {
  def minimumDeviation(nums: Array[Int]): Int = {
    var ts = mutable.TreeSet.empty[Int]
    nums.foreach(n => ts += (if (n % 2 == 0) n else n * 2))
    var res = ts.last - ts.head
    while (res > 0 && (ts.last % 2 == 0)) {
      val v = ts.last
      ts.remove(v)
      ts += v / 2
      res = res.min(ts.last - ts.head)
    }
    res
  }
}
