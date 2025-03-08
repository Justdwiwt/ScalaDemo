package leetCode._3500

object Solution_3471 {
  def largestInteger(nums: Array[Int], k: Int): Int = {
    val m = nums.sliding(k).foldLeft(Map.empty[Int, Int])((agg, v) => {
      v.toSet.foldLeft(agg)((agg, num) => agg.get(num) match {
        case Some(count) => agg.updated(num, count + 1)
        case None => agg.updated(num, 1)
      })
    })

    m.filter { case (_, count) => count == 1 }.keySet.reduceOption(_.max(_)).getOrElse(-1)
  }
}
