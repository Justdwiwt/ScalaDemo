package leetCode._3200

object Solution_3139 {
  val M: Int = 1000000007

  def minCostToEqualizeArray(nums: Array[Int], cost1: Int, cost2: Int): Int = {
    val (min, max, sum) = nums.foldLeft((nums.head, nums.head, 0L)) {
      case ((currentMin, currentMax, currentSum), x) =>
        (currentMin.min(x), currentMax.max(x), currentSum + x)
    }

    val n = nums.length
    val totalIncrement = max.toLong * n - sum

    if (cost1 * 2 <= cost2 || n <= 2) return (totalIncrement * cost1 % M).toInt

    val maxDiff = max - min
    val initialSum1 = (totalIncrement % 2).max(maxDiff * 2 - totalIncrement)
    val sum2 = totalIncrement - initialSum1
    var ans = sum2 / 2 * cost2

    val (sum1, additionalCost) =
      if (cost2 * (n - 1) >= cost1 * (n - 2)) (initialSum1 % (n - 1), initialSum1 / (n - 1) * (n - 1) * cost1)
      else (initialSum1 % (n - 2), initialSum1 / (n - 2) * (n - 1) * cost2)

    ans += additionalCost

    val option1 = sum1 * cost1
    val option2Base = (sum1 + n) / 2 * cost2
    val option2 = option2Base + (
      if ((sum1 + n) % 2 == 1)
        if (n % 2 == 1) cost1.min((n + 1) / 2 * cost2)
        else cost1
      else 0
      )

    ans += option1.min(option2)

    (ans % M).toInt
  }
}
