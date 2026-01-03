package leetCode._3700

object Solution_3698 {
  def splitArray(nums: Array[Int]): Long = {
    val n = nums.length

    val preSeq = nums
      .sliding(2)
      .takeWhile { case Array(a, b) => b > a }
      .map(_(1))
      .toList

    val preSum = (nums.head +: preSeq).map(_.toLong).sum
    val i = preSeq.length + 1

    val sufSeq = nums
      .reverse
      .sliding(2)
      .takeWhile { case Array(a, b) => b > a }
      .map(_(1))
      .toList

    val sufSum = (nums.last +: sufSeq).map(_.toLong).sum
    val j = n - sufSeq.length - 2

    if (i <= j) -1L
    else {
      val d = preSum - sufSum
      if (i - 1 == j) math.abs(d)
      else {
        val x = nums(i - 1).toLong
        (d + x).abs.min((d - x).abs)
      }
    }
  }
}
