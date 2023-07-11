package leetCode

object Solution_2763 {
  def sumImbalanceNumbers(nums: Array[Int]): Int = {
    val vis = Array.fill(nums.length + 2)(-1)
    var res = 0
    nums.indices.foreach(i => {
      var cnt = 0
      vis(nums(i)) = i
      (i + 1 until nums.length).foreach(j => {
        if (vis(nums(j)) != i) {
          cnt += 1
          if (vis(nums(j) - 1) == i) cnt -= 1
          if (vis(nums(j) + 1) == i) cnt -= 1
          vis(nums(j)) = i
        }
        res += cnt
      })
    })
    res
  }
}
