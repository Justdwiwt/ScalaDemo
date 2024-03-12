package leetCode._600

object Solution_565 {
  def arrayNesting(nums: Array[Int]): Int = nums.indices./:((Set.empty[Int], 0)) {
    case (acc@(m, l), i) => if (m.contains(i)) acc else {
      val s = f(nums, Set.empty, i)
      (m ++ s, l.max(s.size))
    }
  }._2

  @scala.annotation.tailrec
  def f(nums: Array[Int], st: Set[Int], idx: Int): Set[Int] = {
    val t = nums(idx)
    if (st.contains(t)) st
    else f(nums, st + t, t)
  }
}
