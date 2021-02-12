package leetCode

object Solution_1017 {
  @scala.annotation.tailrec
  def baseNeg2(N: Int, sig: Int = 0, res: StringBuilder = new StringBuilder): String =
    if (N == 0)
      if (res.isEmpty) "0"
      else res.reverse.mkString
    else baseNeg2(N / 2 + (N & sig), 1 - sig, res.append(N & 1))
}
