package leetCode._700

object Solution_643 {
  def findMaxAverage(nums: Array[Int], k: Int): Double = {
    val sum = (0 until k).toList./:(0)((cur, idx) => cur + nums(idx))
    var mxSum = sum
    (k until nums.length)./:(sum)((cur, idx) => {
      val next = cur - nums(idx - k) + nums(idx)
      mxSum = mxSum.max(next)
      next
    })
    mxSum.toDouble / k.toDouble
  }
}
