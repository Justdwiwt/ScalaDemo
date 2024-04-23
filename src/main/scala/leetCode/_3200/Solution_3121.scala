package leetCode._3200

object Solution_3121 {
  def numberOfSpecialChars(word: String): Int = {
    val (lower, upper, invalid) = word.foldLeft((0L, 0L, 0L)) { case ((lower, upper, invalid), c) =>
      val bit = (1 << (c & 31)).toLong
      if ((c & 32) > 0) (lower | bit, upper, if ((upper & bit) > 0) invalid | bit else invalid)
      else (lower, upper | bit, invalid)
    }
    Integer.bitCount((lower & upper & ~invalid).toInt)
  }
}
