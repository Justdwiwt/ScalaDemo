package leetCode

object Solution_2575 {
  def divisibilityArray(word: String, m: Int): Array[Int] = word
    .map(_ - '0')
    .scanLeft(0L)((acc, v) => (acc * 10 + v) % m)
    .tail
    .map(v => if (v == 0) 1 else 0)
    .toArray
}
