package leetCode._3900

object Solution_3827 {
  def countMonobit(n: Int): Int =
    32 - Integer.numberOfLeadingZeros(n + 1)
}
