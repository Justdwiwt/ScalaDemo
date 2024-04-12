package leetCode._3000

object Solution_2950 {
  def countDivisibleSubstrings(word: String): Int = {
    val n = word.length
    val arr = word.toCharArray
    val nums = word.indices.map(i => (arr(i) - 'a' + 1) / 3 + 1)
    val mx = nums.max
    val mn = nums.min

    if (mx == mn) return (n * (n + 1)) / 2

    val base = 9 * n
    val res = (mn to mx).map(i => {
      val cnt = Array.fill(base * 2 + 1)(0)
      cnt(base) = 1
      var sum = 0
      val subRes = nums.map(x => {
        sum += x - i
        val r = cnt(sum + base)
        cnt(sum + base) += 1
        r
      }).sum
      subRes
    }).sum
    res
  }
}
