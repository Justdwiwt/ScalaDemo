package leetCode

object Offer_58_1 {
  def reverseWords(s: String): String = s.trim.split("\\s+").reverse.mkString(" ")
}
