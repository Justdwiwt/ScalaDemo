package leetCode

object Solution_389 {
  def findTheDifference(s: String, t: String): Char = {
    val tmp = (s + t).toCharArray
    var res: Char = 0
    (0 until tmp.length).foreach(i => res = (res ^ tmp(i)).toChar)
    res
  }
}
