package leetCode

object Solution_1009 {
  def bitwiseComplement(N: Int): Int = N match {
    case 0 => 1
    case _ =>
      var n = 1
      while (n <= N) n <<= 1
      n - 1 - N
  }
}
