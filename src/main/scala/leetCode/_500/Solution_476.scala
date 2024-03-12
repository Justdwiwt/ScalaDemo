package leetCode._500

object Solution_476 {
  def findComplement(num: Int): Int =
    ~num & (Integer.highestOneBit(num) - 1)
}
