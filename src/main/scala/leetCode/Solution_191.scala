package leetCode

object Solution_191 {
  def hammingWeight(n: Int): Int =
    n.toBinaryString.count(_ == '1')
}
