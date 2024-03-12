package leetCode._1500

object Solution_1417 {
  def reformat(s: String): String = {
    val (digits, letters) = s.partition(Character.isDigit)
    if ((digits.length - letters.length).abs > 1) ""
    else {
      val (less, big) = if (digits.length <= letters.length) (digits, letters) else (letters, digits)
      val sb = StringBuilder.newBuilder
      less.indices.foreach(i => {
        sb.append(big(i))
        sb.append(less(i))
      })
      if (big.length > less.length) sb.append(big(big.length - 1))
      sb.mkString
    }
  }
}
