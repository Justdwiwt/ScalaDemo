package leetCode._3800

object Solution_3746 {
  def minLengthAfterRemovals(s: String): Int =
    (s.count(_ == 'a') - s.count(_ == 'b')).abs
}
