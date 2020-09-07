package leetCode

import scala.language.postfixOps

object Solution_482 {
  def licenseKeyFormatting(S: String, K: Int): String = {
    val s = S.filter('-' !=).toUpperCase
    val hT = s.splitAt(s.length % K)
    val h = Iterator(hT._1).filter(_.nonEmpty)
    (h ++ hT._2.grouped(K)).mkString("-")
  }
}
