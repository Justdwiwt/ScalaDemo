package leetCode.offer

object Offer_67 {
  def strToInt(str: String): Int = {
    var i = 0
    var res = 0L
    while (i < str.length) {
      if (str.charAt(i) == '-') {
        while (i < str.length && str.charAt(i) >= '0' && str.charAt(i) <= '9') {
          res = res * 10 + (str.charAt(i) - '0')
          if (res - 1 > Int.MaxValue) return Int.MinValue
          i = i + 1
        }
        res = res * (-1)
        return res.toInt
      }
      else if ((str.charAt(i) >= '0' && str.charAt(i) <= '9') || str.charAt(i) == '+') {
        if (str.charAt(i) == '+') i = i + 1
        while (i < str.length && str.charAt(i) >= '0' && str.charAt(i) <= '9') {
          res = res * 10 + (str.charAt(i) - '0')
          if (res > Int.MaxValue) return Int.MaxValue
          i = i + 1
        }
        return res.toInt
      }
      else if (str.charAt(i) == ' ') i = i + i
      else return 0
    }
    0
  }
}
