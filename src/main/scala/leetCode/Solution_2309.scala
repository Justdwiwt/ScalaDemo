package leetCode

object Solution_2309 {
  def greatestLetter(s: String): String = {
    var k = 0L
    var mask = ((1L << 32) + 1) << 25
    s.toCharArray.foreach(c => k |= (1L << (c - 'A')))
    var idx = 25
    while (idx >= 0) {
      if ((k & mask) == mask) return "" + (idx + 'A').toChar
      idx -= 1
      mask >>= 1
    }
    ""
  }
}
