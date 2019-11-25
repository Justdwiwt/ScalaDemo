package leetCode

object Solution_788 {
  def rotatedDigits(N: Int): Int = {
    var res = 0
    (1 to N).foreach(i => if (func(i)) res += 1)
    res
  }

  def func(v: Int): Boolean = {
    val str = v.toString
    var flag = false
    str.foreach(c => {
      if ((c == '3') || (c == '4') || (c == '7')) return false
      if ((c == '2') || (c == '5') || (c == '6') || (c == '9')) flag = true
    })
    flag
  }
}
