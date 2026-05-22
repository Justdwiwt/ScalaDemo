package leetCode._3900

object Solution_3889 {
  def mirrorFrequency(s: String): Int = {
    val digitFreq = s
      .filter(_.isDigit)
      .groupBy(_ - '0')
      .mapValues(_.length)
      .withDefaultValue(0)

    val charFreq = s
      .filter(_.isLetter)
      .groupBy(_ - 'a')
      .mapValues(_.length)
      .withDefaultValue(0)

    (0 until 5).map(i => math.abs(digitFreq(i) - digitFreq(9 - i))).sum +
      (0 until 13).map(i => math.abs(charFreq(i) - charFreq(25 - i))).sum
  }
}
