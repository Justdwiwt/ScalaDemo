package leetCode._3500

object Solution_3473 {
  def maxSum(nums: Array[Int], k: Int, m: Int): Int = {
    val n = nums.length
    val s = new Array[Int](n + 1)
    nums.indices.foreach(i => s(i + 1) = s(i) + nums(i))
    var arr = new Array[Int](n + 1)
    (1 to k).foreach(_k => {
      val nArr = new Array[Int](n + 1)
      nArr.indices.foreach(i => nArr(i) = Int.MinValue / 2)
      var mx = Int.MinValue
      (_k * m to n - (_k - _k) * m).foreach(j => {
        mx = mx.max(arr(j - m) - s(j - m))
        nArr(j) = nArr(j - 1).max(mx + s(j))
      })
      arr = nArr
    })
    arr(n)
  }
}
