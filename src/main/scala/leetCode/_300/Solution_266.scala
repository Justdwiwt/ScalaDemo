package leetCode._300

import scala.collection.immutable.HashSet

object Solution_266 {
  def canPermutePalindrome(s: String): Boolean =
    s.foldLeft(HashSet.empty[Char])((set, char) => if (set.contains(char)) set - char else set + char).size <= 1
}
