package leetCode.crackingCodeInterview

import scala.language.implicitConversions

object Code_01_04 {
  implicit def charToInt(c: Char): Int = c.toInt

  def canPermutePalindrome(s: String): Boolean = {
    val arr = Array.fill(128)(0)
    s.foreach(c => arr(c) = arr(c) ^ 1)
    arr.sum <= 1
  }
}
