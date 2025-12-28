package leetCode._3700

object Solution_3676 {
  def bowlSubarrays(nums: Array[Int]): Long = nums.foldLeft((List.empty[Int], 0L)) { case ((stack, ans), x) =>
    @scala.annotation.tailrec
    def pop(s: List[Int], a: Long): (List[Int], Long) = s match {
      case h :: t if h < x =>
        val na = if (t.nonEmpty) a + 1 else a
        pop(t, na)
      case _ => (s, a)
    }

    val (ns, na) = pop(stack, ans)
    (x :: ns, na)
  }._2
}
