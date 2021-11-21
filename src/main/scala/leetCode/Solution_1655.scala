package leetCode

import java.util
import scala.collection.mutable

object Solution_1655 {
  def canDistribute(nums: Array[Int], quantity: Array[Int]): Boolean = {
    val sq = quantity.sortWith(_ >= _)
    val m = mutable.HashMap.empty[Int, Int]
    val tm = new util.TreeMap[Int, Int]((a: Int, b: Int) => -Integer.compare(a, b))
    nums.foreach(x => m.put(x, m.getOrElse(x, 0) + 1))
    m.values.foreach(x => tm.put(x, tm.getOrDefault(x, 0) + 1))
    var cnt = 0
    while (cnt < sq.length) {
      val v = sq(cnt)
      if (tm.isEmpty) return false
      val maxKey = tm.firstKey()
      if (maxKey < v) return false
      var t = cnt
      while (t < sq.length && v == sq(t)) t += 1
      t -= 1
      while (t >= cnt) {
        val sum = (t - cnt + 1) * v
        if (tm.containsKey(sum)) {
          tm.put(sum, tm.get(sum) - 1)
          if (tm.get(sum) == 0) tm.remove(sum)
          cnt = t + 1
        } else if (cnt == t) {
          val remain = maxKey - v
          tm.put(maxKey, tm.get(maxKey) - 1)
          if (tm.get(maxKey) == 0) tm.remove(maxKey)
          if (remain != 0) tm.put(remain, tm.getOrDefault(remain, 0) + 1)
          cnt += 1
        }
        t -= 1
      }
    }
    true
  }
}
