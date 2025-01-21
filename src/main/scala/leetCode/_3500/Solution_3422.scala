package leetCode._3500

//fixme: case 741/773 time limit exceeded
object Solution_3422 {
  def minOperations(nums: Array[Int], k: Int): Long = {
    val n = nums.length
    var ans = Long.MaxValue
    (0 to n - k).foreach(i => {
      val window = nums.slice(i, i + k).sorted
      val mid = window((k - 1) / 2)
      var ops = 0L
      (0 until k).foreach(j => ops += math.abs(window(j) - mid))
      ans = math.min(ans, ops)
    })
    ans
  }
}
