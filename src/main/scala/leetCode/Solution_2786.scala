package leetCode

object Solution_2786 {
  def maxScore(nums: Array[Int], x: Int): Long = {
    val INF = Long.MaxValue / 2
    var a = -INF
    var b = -INF
    if ((nums.head & 1) == 1) a = nums.head
    else b = nums.head
    nums.indices.drop(1).foreach(i => {
      val n = nums(i)
      var na = a
      var nb = b
      if ((n & 1) == 1) na = a.max(b - x) + n
      else nb = b.max(a - x) + n
      a = na
      b = nb
    })
    a.max(b)
  }
}
