package leetCode._600

object Solution_504 {
  def convertToBase7(num: Int): String = {
    if (num < 0) return "-" + convertToBase7(-num)
    if (num < 7) return num.toString
    convertToBase7(num / 7) + (num % 7).toString
  }
}
