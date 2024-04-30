package leetCode._1300

object Solution_1259 {
  def numberOfWays(numPeople: Int): Int = {
    if (numPeople == 2) return 1
    val M = math.pow(10, 9).toInt + 7

    val dp = (0 to numPeople).toArray.foldLeft(Array[Long](0, 0, 1))((arr, i) => {
      if (i < 3) arr
      else {
        val sum = {
          (4 to i - 2 by 2).foldLeft(0L)((s, k) => s + (arr(k - 2) * arr(i - k)) % M)
        }
        arr :+ ((2 * arr(i - 2) % M + sum) % M)
      }
    })

    (dp(numPeople) % M).toInt
  }
}
