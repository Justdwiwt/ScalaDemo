package leetCode

object Offer_58_2 {
  def reverseLeftWords(s: String, n: Int): String = s.substring(n, s.length) + s.substring(0, n)
}
