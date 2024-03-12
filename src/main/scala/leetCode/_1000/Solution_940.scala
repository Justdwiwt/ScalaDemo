package leetCode._1000

object Solution_940 {
  def distinctSubseqII(S: String): Int = {
    val (r, _) = S./:((BigInt(0), Map.empty[Char, BigInt])) {
      case ((dp, last), c) => (2 * dp - last.getOrElse(c, -1), last.updated(c, dp))
    }

    (r % 1000000007).toInt
  }
}
