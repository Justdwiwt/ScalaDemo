package leetCode

object Offer_56_2 {
  def singleNumber(nums: Array[Int]): Int = {
    var res = 0
    (0 until 32).foreach(i => {
      var cnt = 0
      nums.foreach(v => if ((v & 1 << i) > 0) cnt += 1)
      if (cnt % 3 == 1) res ^= (1 << i)
    })
    res
  }
}
