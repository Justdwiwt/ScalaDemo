package leetCode

import scala.collection.mutable

object Solution_956 {
  def tallestBillboard(rods: Array[Int]): Int = {
    val dp = mutable.HashMap.empty[Int, Int]
    dp += 0 -> 0
    rods.foreach(x => {
      val cur = dp.clone()
      cur.keySet.foreach(d => {
        dp += (d + x) -> cur.getOrElse(d, 0).max(dp.getOrElse(x + d, 0))
        dp += (d - x).abs -> (cur.getOrElse(d, 0) + d.min(x)).max(dp.getOrElse((d - x).abs, 0))
      })
    })
    dp.getOrElse(0, 0)
  }
}
