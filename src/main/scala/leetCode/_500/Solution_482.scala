package leetCode._500

object Solution_482 {
  def licenseKeyFormatting(S: String, K: Int): String = S
    .replace("-", "")
    .reverse
    .grouped(K)
    .toList
    .map(_.reverse.mkString("").toUpperCase)
    .reverse
    .mkString("-")
}
