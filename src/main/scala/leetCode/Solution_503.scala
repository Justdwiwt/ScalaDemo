package leetCode

object Solution_503 {
  def nextGreaterElements(nums: Array[Int]): Array[Int] = {
    @scala.annotation.tailrec
    def f(idx: Int, cnt: Int, st: Seq[Int], out: Array[Int]): Array[Int] =
      if (idx == nums.length && cnt == 2) out
      else if (idx == nums.length) f(0, cnt + 1, st, out)
      else if (st.isEmpty) f(idx + 1, cnt, idx +: st, out)
      else if (nums(idx) > nums(st.head) && out(st.head) == -1) {
        out(st.head) = nums(idx)
        f(idx, cnt, st.tail, out)
      } else if (cnt == 0) f(idx + 1, cnt, idx +: st, out)
      else f(idx + 1, cnt, st, out)

    f(0, 0, Nil, Array.fill(nums.length)(-1))
  }
}
