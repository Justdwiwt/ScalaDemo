package leetCode._3000

import scala.collection.mutable
import scala.util.control.Breaks._

object Solution_2910 {
  def minGroupsForValidAssignment(nums: Array[Int]): Int = {
    val cnt = mutable.Map.empty[Int, Int].withDefaultValue(0)
    nums.foreach(x => cnt(x) += 1)
    var n = nums.length
    cnt.values.foreach(c => n = n.min(c))
    val flag = true
    while (flag) {
      var res = 0
      breakable({
        cnt.values.foreach(c => {
          if (c / n < c % n) {
            res = 0
            break
          }
          res += (c + n) / (n + 1)
        })
      })
      if (res > 0) return res
      n -= 1
    }
    0
  }
}
