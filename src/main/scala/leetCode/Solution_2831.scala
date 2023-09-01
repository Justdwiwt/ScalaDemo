package leetCode

object Solution_2831 {
  def longestEqualSubarray(nums: List[Int], k: Int): Int = {
    val n = nums.length
    var list = Array.empty[List[Int]]
    (0 to n).foreach(_ => list :+= List.empty[Int])
    nums.indices.foreach(i => list(nums(i)) :+= i)
    var res = 0
    (1 to n).foreach(u => {
      var q = list(u)
      var i = 0
      var j = 0
      while (i < q.length) {
        while ((q(i) - q(j)) - (i - j) > k) j += 1
        res = res.max(i - j + 1)
        i += 1
      }
    })
    res
  }
}
