package leetCode._3300

import scala.collection.mutable

object Solution_3272 {
  def countGoodIntegers(n: Int, k: Int): Long = {
    val str = "1" * n
    val sb = new StringBuilder(str)
    val st = mutable.Set.empty[String]
    rec(sb, n, 0, k, st)
  }

  private def rec(s: StringBuilder, n: Int, i: Int, k: Int, list: mutable.Set[String]): Long = {
    if (s.head == '0') return 0
    if (i == (n + 1) / 2) div(s, k, list)
    else {
      var res = 0L
      ('0' to '9').foreach(c => {
        s.setCharAt(i, c)
        s.setCharAt(n - i - 1, c)
        res += rec(s, n, i + 1, k, list)
      })
      res
    }
  }

  private def factorial(n: Int): Long =
    (2 to n).foldLeft(1L)(_ * _)

  private def perm(digits: Array[Int]): Long = {
    val totalDigits = digits.sum
    var res = 0L

    (1 to 9).foreach(i => if (digits(i) > 0) {
      digits(i) -= 1
      var permutations = factorial(totalDigits - 1)
      digits.withFilter(_ > 1).foreach(permutations /= factorial(_))
      res += permutations
      digits(i) += 1
    })
    res
  }

  private def div(s: StringBuilder, k: Int, list: mutable.Set[String]): Long = {
    val num = s.toString.toLong
    if (num % k != 0) return 0

    val digits = Array.fill(10)(0)
    s.toString.foreach(ch => digits(ch - '0') += 1)

    val digitsStr = digits.mkString(",")
    if (list.contains(digitsStr)) return 0
    list += digitsStr

    perm(digits)
  }
}
