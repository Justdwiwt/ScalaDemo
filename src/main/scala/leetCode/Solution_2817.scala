package leetCode

import java.util
import scala.collection.JavaConverters._

object Solution_2817 {
  def minAbsoluteDifference(nums: List[Int], x: Int): Int = {
    val a = nums.asJava.stream().mapToInt(i => i).toArray
    var res = Integer.MAX_VALUE
    val n = a.length
    val s = new util.TreeSet[Integer]()
    s.add(Integer.MAX_VALUE)
    s.add(Integer.MIN_VALUE / 2)
    (x until n by 1).foreach(i => {
      s.add(a(i - x))
      val y = a(i)
      res = math.min(res, math.min(s.ceiling(y) - y, y - s.floor(y)))
    })
    res
  }
}
