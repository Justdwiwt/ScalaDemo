package leetCode._1600

object Solution_1544 {
  def makeGood(s: String): String = {
    val res = new StringBuilder(s)
    var i = 0
    while (i <= res.length - 2) {
      if ((res(i) - res(i + 1)).abs == 32) {
        res.delete(i, i + 2)
        i = 0
      } else i += 1
    }
    res.toString()
  }
}
