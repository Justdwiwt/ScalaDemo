package leetCode

object Solution_476 {
  def findComplement(num: Int): Int = (1 - num % 2) + 2 * (if (num <= 1) 0 else findComplement(num / 2))
}
