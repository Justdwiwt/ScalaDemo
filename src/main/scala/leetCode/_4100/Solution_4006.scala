package leetCode._4100

object Solution_4006 {
  def countValidPrefixes(s: String): Int = s.foldLeft((0, 0, 0)) {
    case ((count, zeros, ones), c) =>
      val (newZeros, newOnes) = if (c == '0') (zeros + 1, ones) else (zeros, ones + 1)
      if ((newZeros - newOnes).abs < 2) (count + 1, newZeros, newOnes)
      else (count, newZeros, newOnes)
  }._1
}
