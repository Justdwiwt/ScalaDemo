package leetCode._3300

object Solution_3267 {
  private val Pow10 = Array(1, 10, 100, 1000, 10000, 100000, 1000000)

  def countPairs(nums: Array[Int]): Int = {
    val freq = scala.collection.mutable.Map[Int, Int]().withDefaultValue(0)

    nums.foldLeft(0)((res, v) => {
      val updated = res + freq(v)
      val swap = allOneSwapVariations(v).flatMap(allOneSwapVariations)
      swap.foreach(variation => freq(variation) = freq(variation) + 1)
      updated
    })
  }

  private def allOneSwapVariations(number: Int): Set[Int] = (0 until 7)
    .flatMap(i => (i + 1 until 7)
      .map { j => val di = (number / Pow10(i)) % 10; (j, di) }
      .map { case (j, di) => val dj = (number / Pow10(j)) % 10; (j, di, dj) }
      .withFilter { case (_, di, dj) => di != dj }
      .map { case (j, di, dj) => number - di * Pow10(i) + di * Pow10(j) - dj * Pow10(j) + dj * Pow10(i) }
    ).toSet + number
}
