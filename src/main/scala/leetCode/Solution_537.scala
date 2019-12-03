package leetCode

object Solution_537 {
  def complexNumberMultiply(a: String, b: String): String = {
    val x = a.split("[+i]")
    val y = b.split("[+i]")
    val aReal = x(0).toInt
    val aImg = x(1).toInt
    val bReal = y(0).toInt
    val bImg = y(1).toInt
    (aReal * bReal - aImg * bImg) + "+" + (aReal * bImg + aImg * bReal) + "i"
  }
}
