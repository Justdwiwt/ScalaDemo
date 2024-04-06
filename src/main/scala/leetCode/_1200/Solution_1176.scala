package leetCode._1200

object Solution_1176 {
  def dietPlanPerformance(calories: Array[Int], k: Int, lower: Int, upper: Int): Int = {
    val acc = calories.scanLeft(0)(_ + _).drop(1)
    val score = (k - 1 until calories.length).map(i => {
      val calory = if (i == k - 1) acc(i) else acc(i) - acc(i - k)
      if (calory < lower) -1
      else if (calory > upper) 1
      else 0
    }).sum
    score
  }
}
