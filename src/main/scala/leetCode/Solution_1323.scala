package leetCode

object Solution_1323 {
  def maximum69Number(num: Int): Int = {
    num.toString.replaceFirst("6", "9").toInt
  }
}
