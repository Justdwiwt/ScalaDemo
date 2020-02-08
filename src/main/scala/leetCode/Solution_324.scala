package leetCode

object Solution_324 {
  def wiggleSort(nums: Array[Int]): Unit = {
    var tmp = nums
    var k = (nums.length + 1) / 2
    var j = nums.length
    tmp = tmp.sorted
    nums.indices.foreach(i => nums(i) = if ((i & 1) > 0) {
      j -= 1
      tmp(j)
    } else {
      k -= 1
      tmp(k)
    })
  }
}
