package leetCode._3600

object Solution_3541 {
  def maxFreqSum(s: String): Int = {
    val freq = new Array[Int](26)
    val (max1, max2) = s.toCharArray.foldLeft((0, 0)) {
      case ((max1, max2), c) =>
        freq(c.asInt) += 1
        if (isVowel(c)) (max1.max(freq(c.asInt)), max2)
        else (max1, max2.max(freq(c.asInt)))
    }
    max1 + max2
  }

  private def isVowel(c: Char): Boolean =
    c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u'

  implicit class ToInt(c: Char) {
    def asInt: Int = c - 'a'
  }
}
