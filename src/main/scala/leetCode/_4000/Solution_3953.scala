package leetCode._4000

import scala.collection.mutable.ArrayBuffer

object Solution_3953 {
  private val MX = 100001

  private val mu = Array.fill(MX)(0)
  mu(1) = 1

  (1 until MX).foreach(i => (i * 2 until MX by i).foreach(mu(_) -= mu(i)))

  private val divisors = Array.fill(MX)(ArrayBuffer[Int]())

  (2 until MX).withFilter(mu(_) != 0).foreach(i => (i until MX by i).foreach(divisors(_) += i))

  def maxScore(nums: Array[Int], maxVal: Int): Int = {
    val maxNum = nums.max

    val cnt = Array.fill(maxNum + 1)(0)
    nums.foreach(cnt(_) += 1)

    val cntMulti = Array.fill(maxNum + 1)(0)
    (2 to maxNum).foreach(i => (i to maxNum by i).foreach(cntMulti(i) += cnt(_)))

    var ans = if (cnt(1) > 0) 1 else 0

    var selected = maxNum.max(maxVal)
    while (selected > ans) {
      if (!(selected > maxVal && (selected > maxNum || cnt(selected) == 0))) {
        var cost = 0

        val ds = divisors(selected)
        var k = 0
        while (k < ds.length && ds(k) <= maxNum) {
          val d = ds(k)
          cost -= mu(d) * cntMulti(d)
          k += 1
        }

        if (selected <= maxNum && cnt(selected) > 0) cost -= 1
        else if (cost == 0) cost = 1

        ans = ans.max(selected - cost)
      }
      selected -= 1
    }

    ans
  }
}
