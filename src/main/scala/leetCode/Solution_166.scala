package leetCode

import scala.collection.mutable

object Solution_166 {
  def fractionToDecimal(numerator: Int, denominator: Int): String = func(numerator.toLong, denominator.toLong)

  def func(numerator: Long, denominator: Long): String = {
    var myInteger = (numerator / denominator).toString
    if (numerator % denominator == 0) return myInteger
    if ((numerator < 0 && denominator > 0) || (numerator > 0 && denominator < 0)) if (myInteger == "0") myInteger = "-0"
    var _numerator = numerator.abs
    var _denominator = denominator.abs
    _numerator %= _denominator
    var s = ""
    val m = new mutable.HashMap[Long, Int]()
    var pos = 0
    while (_numerator > 0) {
      m(_numerator) = pos
      pos += 1
      _numerator *= 10
      s += (_numerator / _denominator + '0').toString
      _numerator %= _denominator
      if (m.contains(_numerator)) {
        val idx = m(_numerator)
        return myInteger + "." + s.substring(0, idx) + "(" + s.substring(idx) + ")"
      }
    }
    myInteger + "." + s
  }
}
