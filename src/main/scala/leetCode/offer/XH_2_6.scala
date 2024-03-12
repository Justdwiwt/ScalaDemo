package leetCode.offer

object XH_2_6 {
  def maxProductII(nums: Array[Double]): Double = {
    var maxF = nums.head
    var minF = nums.head
    var res = nums.head
    (1 until nums.length).foreach(i => {
      val mx = maxF
      val mn = minF
      maxF = (mx * nums(i)).max(nums(i).max(mn * nums(i)))
      minF = (mn * nums(i)).min(nums(i).min(mx * nums(i)))
      res = maxF.max(res)
    })
    res
  }
}
