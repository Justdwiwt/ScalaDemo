package leetCode._3400

object Solution_3304 {
  def kthCharacter(k: Int): Char =
    "abcdefghijklmnopqrstuvwxyz"(Integer.bitCount(k - 1))
}
