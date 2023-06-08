package leetCode

object Solution_2712 {
  def minimumCost(s: String): Long = s
    .indices
    .drop(1)
    ./:(0L)((acc, i) => if (s.charAt(i) != s.charAt(i - 1)) acc + i.min(s.length - i) else acc)
}
