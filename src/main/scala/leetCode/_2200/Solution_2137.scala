package leetCode._2200

object Solution_2137 {
  def equalizeWater(buckets: Array[Int], loss: Int): Double = {
    val epsilon = 0.000001

    @scala.annotation.tailrec
    def findMid(left: Double, right: Double): Double =
      if (right - left < epsilon) left
      else {
        val mid = (left + right) / 2.0
        val sum = buckets.foldLeft(0.0)((acc, item) => {
          if (item > mid) acc + (item - mid) * (100.0 - loss) / 100.0
          else acc - (mid - item)
        })
        if (sum > 0) findMid(mid, right)
        else findMid(left, mid)
      }

    findMid(0.0, 100000.0)
  }
}
