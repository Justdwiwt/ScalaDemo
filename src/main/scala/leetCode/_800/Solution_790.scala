package leetCode._800

object Solution_790 {
  @scala.annotation.tailrec
  def numTilings(N: Int, a: Int = 0, b: Int = 1, c: Int = 1): Int = {
    if (N == 1) c else numTilings(N - 1, b, c, (c * 2 % 1000000007 + a) % 1000000007)
  }
}
