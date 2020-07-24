package leetCode

object Solution_1415 {
  def getHappyString(n: Int, k: Int): String = {
    if (k > 3 * math.pow(2, n - 1)) return ""
    var res = new StringBuilder
    var t = k - 1
    (1 to n).reverse.foreach(i => {
      val c = math.pow(2, i - 1).toInt
      val tmp = t / c
      t = t % c
      if (i == n) res ++= ('a' + tmp).toChar.toString
      else {
        res.last match {
          case 'a' => res += (if (tmp > 0) 'c' else 'b')
          case 'b' => res += (if (tmp > 0) 'c' else 'a')
          case 'c' => res += (if (tmp > 0) 'b' else 'a')
          case _ =>
        }
      }
    })
    res.toString()
  }
}
