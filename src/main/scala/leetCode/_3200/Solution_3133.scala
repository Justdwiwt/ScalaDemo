package leetCode._3200

object Solution_3133 {
  def minEnd(n: Int, x: Int): Long = {
    val num = n - 1

    @scala.annotation.tailrec
    def cal(res: Long, j: Int, t: Long): Long =
      if (num >> j > 0) {
        val lb = t & -t
        val updatedAns = res | ((num >> j & 1L) * lb)
        cal(updatedAns, j + 1, t ^ lb)
      } else res

    cal(x.toLong, 0, ~x.toLong)
  }
}
