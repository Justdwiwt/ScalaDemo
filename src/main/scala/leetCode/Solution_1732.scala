package leetCode

object Solution_1732 {
  def largestAltitude(gain: Array[Int]): Int =
    gain.scanLeft(0)(_ + _).max
}
