package leetCode._2200

object Solution_2104 {
  def subArrayRanges(nums: Array[Int]): Long = {
    var res = 0L
    nums.indices.foreach(i => {
      var mx = nums(i)
      var mn = nums(i)
      (i + 1 until nums.length).foreach(j => {
        mx = mx.max(nums(j))
        mn = mn.min(nums(j))
        res += (mx - mn)
      })
    })
    res
  }
}
