package leetCode

object Solution_190 {
  def reverseBits(n: Int): Int = n
    .toBinaryString
    .reverse
    .padTo(32, '0')
    ./:(0)((p, n) => (p << 1) + (n - '0'))
}
