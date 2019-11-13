package leetCode

object Solution_829 {
  def consecutiveNumbersSum(N: Int): Int = {
    var res = 0
    var sum = 0
    var i = 1
    while (sum < N) {
      sum += i
      if ((N - sum) % i == 0) res += 1
      i += 1
    }
    res
  }
}
