package leetCode

import scala.collection.mutable

object Solution_956 {
  def tallestBillboard(rods: Array[Int]): Int = {
    val dp = new mutable.HashMap[Int, Int]()
    dp(0) = 0
    rods.foreach(rod => {
      val cur = dp
      cur.foreach(kv => {
        val k = kv._1
        dp(k + rod) = dp(k + rod).max(cur(k))
        dp(math.abs(k - rod)) = dp(math.abs(k - rod)).max(cur(k) + rod.min(k))
      })
    })
    dp(0)
  }
}
