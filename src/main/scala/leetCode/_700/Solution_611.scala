package leetCode._700

object Solution_611 {
  def triangleNumber(nums: Array[Int]): Int = {
    val arr = nums.sorted
    var res = 0
    (2 until arr.length).reverse.foreach(i => {
      var k = 0
      var j = i - 1
      while (k < j) {
        if (arr(k) + arr(j) > arr(i)) {
          res += j - k
          j -= 1
        } else k += 1
      }
    })
    res
  }
}
