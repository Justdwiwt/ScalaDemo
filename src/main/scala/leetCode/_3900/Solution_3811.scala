package leetCode._3900

object Solution_3811 {
  private val M = 1000000007

  case class State(pre: Int, f1: Map[Int, Long], f2: Map[Int, Long], ans: Long)

  def alternatingXOR(nums: Array[Int], target1: Int, target2: Int): Int = {
    val init = State(0, Map.empty, Map(0 -> 1L), 0L)

    val res = nums.indices.foldLeft(init)((st, i) => {
      val cur = st.pre ^ nums(i)

      val last1 = st.f2.getOrElse(cur ^ target1, 0L)
      val last2 = st.f1.getOrElse(cur ^ target2, 0L)

      if (i == nums.length - 1) st.copy(pre = cur, ans = (last1 + last2) % M)
      else st.copy(
        pre = cur,
        f1 = st.f1.updated(cur, (st.f1.getOrElse(cur, 0L) + last1) % M),
        f2 = st.f2.updated(cur, (st.f2.getOrElse(cur, 0L) + last2) % M)
      )
    })

    res.ans.toInt
  }
}
