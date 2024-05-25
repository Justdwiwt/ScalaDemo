package leetCode._2900

import scala.util.Sorting

object Solution_2813 {
  def findMaximumElegance(items: Array[Array[Int]], k: Int): Long = {
    Sorting.quickSort(items)(Ordering.by(-_.head))

    val n = items.length
    var m = 0
    val stack = Array.fill(n)(0)
    val cate = Array.fill(n + 1)(0)
    var sum = 0L
    var res = 0L
    var typ = 0L

    (0 until k).foreach(i => {
      sum += items(i).head
      if (cate(items(i)(1)) > 0) {
        stack(m) = items(i).head
        m += 1
      } else typ += 1
      cate(items(i)(1)) += 1
    })

    res = res.max(sum + typ * typ)

    (k until n)
      .withFilter(_ => m > 0)
      .foreach(i => {
        if (cate(items(i)(1)) == 0) {
          typ += 1
          sum -= stack(m - 1) - items(i).head
          m -= 1
          res = res.max(sum + typ * typ)
        }
        cate(items(i)(1)) += 1
      })

    res
  }
}
