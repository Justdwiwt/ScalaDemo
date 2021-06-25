package leetCode

object Solution_967 {
  def numsSameConsecDiff(N: Int, K: Int): Array[Int] = {
    @scala.annotation.tailrec
    def f(cnt: Int, res: List[Int]): Array[Int] =
      if (cnt == N) res.toArray
      else {
        @inline
        val next = res./:(List.empty[Int]) {
          case (acc, num) => num % 10 match {
            case unit if K == 0 => num * 10 + unit + K :: acc
            case unit if unit + K < 10 && unit - K >= 0 => num * 10 + unit + K :: num * 10 + unit - K :: acc
            case unit if unit + K < 10 => num * 10 + unit + K :: acc
            case unit if unit - K >= 0 => num * 10 + unit - K :: acc
            case _ => acc
          }
        }

        f(cnt + 1, next)
      }

    if (N == 1) (0 to 9).toArray
    else f(1, (1 to 9).toList)
  }
}
