package leetCode

object Solution_477 {
  def totalHammingDistance(nums: Array[Int]): Int = {
    var res = 0
    (0 until 32).foreach(i => {
      var cnt = 0
      nums.foreach(v => cnt += (v >> i) & 1)
      res += cnt * (nums.length - cnt)
    })
    res
  }
}
