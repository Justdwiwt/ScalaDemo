package leetCode._3900

object Solution_3858 {
  def minimumOR(grid: Array[Array[Int]]): Int = {
    val mx = grid.map(_.min).max
    val bitLen = (32 - Integer.numberOfLeadingZeros(mx)).max(1)

    (bitLen - 1 to 0 by -1).foldLeft(0) { (ans, i) =>
      val mask = ans | ((1 << i) - 1)
      if (grid.forall(_.exists(x => (x | mask) == mask))) ans
      else ans | (1 << i)
    }
  }
}
