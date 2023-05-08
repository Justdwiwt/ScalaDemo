package leetCode

object Solution_2654 {
  def minOperations(nums: Array[Int]): Int = {
    val n = nums.length
    var mn = Int.MaxValue
    val cnt = nums.count(_ == 1)
    if (cnt > 0) return n - cnt
    nums.indices.foreach(i => {
      var pre = nums(i)
      (i + 1 until nums.length).foreach(j => {
        pre = gcd(pre, nums(j))
        if (pre == 1) mn = mn.min(j - i - 1 + n)
      })
    })
    if (mn == Int.MaxValue) -1 else mn
  }

  @scala.annotation.tailrec
  private def gcd(a: Int, b: Int): Int =
    if (b == 0) a else gcd(b, a % b)
}
