package leetCode

object Solution_1425 {
  def constrainedSubsetSum(nums: Array[Int], k: Int): Int = {
    if (nums.isEmpty) return 0
    var res = nums(0)
    var pos = 0
    var sums = Array.empty[Int]
    sums :+= res
    (1 until nums.length).foreach(i => {
      var mx = nums(i)
      if (i - pos < k) mx = if (res > 0) mx + res else mx
      else {
        var j = i - 1
        while (j >= 0 && j >= i - k) {
          if (mx < sums(j) + nums(i)) mx = sums(j) + nums(i)
          j -= 1
        }
      }
      sums :+= mx
      if (res < mx) {
        res = mx
        pos = i
      }
    })
    res
  }
}
