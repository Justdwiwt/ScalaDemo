package leetCode._2600

import scala.collection.mutable

object Solution_2524 {
  val M = 1000000007L

  def maxFrequencyScore(nums: Array[Int], k: Int): Int = {
    var res = 0
    var score = 0L
    val m = mutable.HashMap.empty[Int, mutable.Stack[Int]]

    nums.indices.foreach(i => {
      val x = nums(i)
      if (!m.contains(x)) {
        score += x
        val st = mutable.Stack(x)
        m.put(x, st)
      } else {
        val st = m(x)
        val last = st.top
        val cur = (last.toLong * x) % M
        score += cur - last
        st.push(cur.toInt)
      }
      if (i >= k - 1) {
        res = res.max((score % M).toInt)
        val x = nums(i - k + 1)
        val st = m(x)
        score -= st.pop()
        if (st.isEmpty) m.remove(x)
        else score += st.top
      }
    })
    res
  }
}
