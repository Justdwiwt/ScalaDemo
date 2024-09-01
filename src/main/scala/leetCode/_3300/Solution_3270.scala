package leetCode._3300

object Solution_3270 {
  def generateKey(num1: Int, num2: Int, num3: Int): Int = {
    val zipped = (num1.toString.padTo(4, '0'), num2.toString.padTo(4, '0'), num3.toString.padTo(4, '0')).zipped
    val minDigits = zipped.map((c1, c2, c3) => c1.min(c2).min(c3)).mkString
    minDigits.toInt
  }
}
