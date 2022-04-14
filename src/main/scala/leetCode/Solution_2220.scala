package leetCode

object Solution_2220 {
  def minBitFlips(start: Int, goal: Int): Int = (start ^ goal)
    .toBinaryString
    .toCharArray
    .count(_ == '1')
}
