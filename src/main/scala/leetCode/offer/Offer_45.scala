package leetCode.offer

object Offer_45 {
  def minNumber(nums: Array[Int]): String = {
    val str = Array.ofDim[String](nums.length)
    nums.indices.foreach(i => str(i) = nums(i).toString)
    val t = str.sortWith(_ < _)
    var res = ""
    t.foreach(res += _)
    res
  }
}
