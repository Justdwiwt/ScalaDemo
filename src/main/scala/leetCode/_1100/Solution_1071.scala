package leetCode._1100

object Solution_1071 {
  def gcdOfStrings(str1: String, str2: String): String = {
    if (!(str1 + str2).equals(str2 + str1)) return ""
    str1.substring(0, gcd(str1.length, str2.length))
  }

  @scala.annotation.tailrec
  def gcd(a: Int, b: Int): Int = if (b == 0) a else gcd(b, a % b)
}
