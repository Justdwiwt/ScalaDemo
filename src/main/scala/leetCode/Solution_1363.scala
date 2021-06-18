package leetCode

object Solution_1363 {
  def largestMultipleOfThree(digits: Array[Int]): String = {
    val d1 = digits.filter(n => n % 3 == 1).sorted
    val d2 = digits.filter(n => n % 3 == 2).sorted
    val d3 = digits.filter(n => n % 3 == 0)
    val res = (
      if (digits.sum % 3 == 1)
        if (d1.length != 0) Array.concat(Array.concat(d1.drop(1), d2), d3)
        else Array.concat(d2.drop(2), d3)
      else if (digits.sum % 3 == 2)
        if (d2.length != 0) Array.concat(Array.concat(d1, d2.drop(1)), d3)
        else Array.concat(d1.drop(2), d3)
      else digits
      ).sortWith(_ > _)
    if (res.isEmpty) return ""
    if (res./:("0")((b, a) => b.concat(a.toString)).dropWhile(_ == '0').nonEmpty)
      return res./:("0")((b, a) => b.concat(a.toString)).dropWhile(_ == '0')
    "0"
  }
}
