package leetCode._3200

object Solution_3139 {
  val mod: Int = 1000000007

  def minCostToEqualizeArray(nums: Array[Int], cost1: Int, cost2: Int): Int = {
    var max = 0
    var min = nums(0)
    var sum: Long = 0
    for (x <- nums) {
      if (x < min) min = x
      if (x > max) max = x
      sum += x
    }

    val n: Int = nums.length
    sum = max.toLong * n - sum

    if (cost1 * 2 <= cost2 || n <= 2) {
      return (sum * cost1 % mod).toInt
    }

    val maxDiff: Long = max - min
    var sum1: Long = math.max(sum % 2, maxDiff * 2 - sum)
    val sum2: Long = sum - sum1
    var ans: Long = sum2 / 2 * cost2

    if (cost2 * (n - 1) >= cost1 * (n - 2)) {
      ans += sum1 / (n - 1) * (n - 1) * cost1
      sum1 %= n - 1
    } else {
      ans += sum1 / (n - 2) * (n - 1) * cost2
      sum1 %= n - 2
    }

    val option1: Long = sum1 * cost1
    var option2: Long = (sum1 + n) / 2 * cost2
    if ((sum1 + n) % 2 == 1)
      option2 += (if (n % 2 == 1) math.min(cost1, (n + 1) / 2 * cost2) else cost1)

    ans += math.min(option1, option2)

    (ans % mod).toInt
  }
}
