package leetCode._2200

object Solution_2137 {
  def equalizeWater(buckets: Array[Int], loss: Int): Double = {
    var left = 0.0
    var right = 100000.0
    val r = 0.000001
    while (right - left >= r) {
      val mid = (left + right) / 2.0
      var sum = 0.0
      buckets.foreach(item => if (item > mid) sum += (item - mid) * (100.0 - loss) / 100.0 else sum -= mid - item)
      if (sum > 0) left = mid
      else right = mid
    }
    left
  }
}
