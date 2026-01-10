package leetCode._3800

object Solution_3722 {
  def lexSmallest(s: String): String = s
    .indices
    .flatMap(i => {
      val (l, r) = s.splitAt(i)
      List(l.reverse + r, l + r.reverse)
    })
    .min
}
