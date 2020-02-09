package leetCode

object Solution_190 {
  def reverseBits(n: Int): Int = {
    var res = 0
    (0 until 32).foreach(i => res |= ((n >> i) & 1) << (32 - i))
    res
  }
}
