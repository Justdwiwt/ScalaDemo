package leetCode._3800

object Solution_3782 {
  def lastInteger(n: Long): Long =
    ((n - 1) & 0xAAAAAAAAAAAAAAAL) + 1
}
