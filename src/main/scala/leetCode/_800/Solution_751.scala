package leetCode._800

object Solution_751 {
  def ipToCIDR(ip: String, n: Int): List[String] = {
    val num = getNum(ip)
    process(num, n, 0, useDigit = false)
  }

  private def process(num: Int, n: Int, digit: Int, useDigit: Boolean): List[String] = {
    if (n == 0) return Nil
    if (n == 1) return List(getStr(num, 0))

    if (useDigit) {
      val curN = 1 << digit
      if (curN <= n) {
        val rest = process(num + curN, n - curN, digit - 1, useDigit = true)
        getStr(num, digit) :: rest
      } else process(num, n, digit - 1, useDigit = true)
    } else {
      val curN = num & -num
      if (curN == 0) return process(num, n, 30, useDigit = true)
      val digit = getDigit(curN)
      if (curN <= n) {
        val rest = process(num + curN, n - curN, digit, useDigit = false)
        getStr(num, digit) :: rest
      } else process(num, n, digit - 1, useDigit = true)
    }
  }

  private def getDigit(num: Int): Int =
    Iterator.iterate(num)(_ >> 1).takeWhile(_ > 0).toList.length - 1

  private def getStr(num: Int, digit: Int): String =
    s"${(num & 0xFF000000) >>> 24}.${(num & 0x00FF0000) >>> 16}.${(num & 0x0000FF00) >>> 8}.${num & 0x000000FF}/${32 - digit}"


  private def getNum(ip: String): Int =
    ip.split("\\.").foldLeft(0)((acc, s) => acc * 256 + s.toInt)
}
