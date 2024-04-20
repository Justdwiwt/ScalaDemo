package leetCode._2500

object Solution_2417 {
  def closestFair(n: Int): Int = {
    val len = n.toString.length
    val one = (len + 2 - len % 2) / 2
    val ones = "111111"
    val zeros = "000000"
    val ans = ("1" + zeros.substring(0, one) + ones.substring(0, one - 1)).toLong
    if (len % 2 == 1) ans.toInt
    else {
      val res = Stream.from(n).take(math.pow(10, one + 1).toInt).find(i => {
        val c = i.toString.map(_.asDigit).map(v => if (v % 2 == 0) 1 else -1).sum
        c == 0
      })
      res.getOrElse(ans.toInt)
    }
  }
}
