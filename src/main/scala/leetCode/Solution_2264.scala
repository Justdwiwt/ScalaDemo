package leetCode

object Solution_2264 {
  def largestGoodInteger(num: String): String = {
    val subs = (0 to num.length - 3).map(i => num.substring(i, i + 3))
    val fSubs = subs.filter(s => s(0) == s(1) && s(1) == s(2))
    if (fSubs.isEmpty) ""
    else {
      val ints = fSubs.map(_.toInt)
      "%03d".format(ints.max)
    }
  }
}
