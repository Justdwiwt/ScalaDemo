package leetCode._2900

import scala.util.control.Breaks._

object Solution_2861 {
  def maxNumberOfAlloys(n: Int, k: Int, budget: Int, composition: List[List[Int]], stock: List[Int], cost: List[Int]): Int = {
    var res = 0
    val mx = stock.min + budget
    composition.foreach(com => {
      var l = 0
      var r = mx + 1
      while (l + 1 < r) {
        val mid = (l + r) >>> 1
        var flag = true
        var money = 0L
        (0 until n).foreach(i => breakable(if (stock(i) < com(i).toLong * mid) {
          money += (com(i).toLong * mid - stock(i)) * cost(i)
          if (money > budget) {
            flag = false
            break
          }
        }))
        if (flag) l = mid
        else r = mid
      }
      res = res.max(l)
    })
    res
  }
}
