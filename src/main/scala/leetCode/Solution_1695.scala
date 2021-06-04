package leetCode

object Solution_1695 {
  def maximumUniqueSubarray(nums: Array[Int]): Int = {
    @scala.annotation.tailrec
    def f(st: Set[Int], li: List[Int], lj: List[Int], cs: Int, acc: Int): Int = lj match {
      case Nil => acc
      case j :: _ if st.contains(j) =>
        f(st - li.head, li.tail, lj, cs - li.head, acc)
      case j :: js =>
        val ncs = cs + j
        f(st + j, li, js, ncs, ncs.max(acc))
    }

    f(Set.empty, nums.toList, nums.toList, 0, 0)
  }
}
