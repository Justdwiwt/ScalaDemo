package leetCode._3600

object Solution_3592 {
  def findCoins(numWays: Array[Int]): List[Int] = {
    val n = numWays.length
    val target = numWays.zipWithIndex.map { case (v, i) => (i + 1) -> v }.toMap

    val initialF = Map(0 -> 1).withDefaultValue(0)

    val (_, coins, valid) = (1 to n).foldLeft((initialF, List.empty[Int], true)) {
      case ((f, acc, true), i) =>
        val expected = target(i)
        val current = f.getOrElse(i, 0)
        if (expected == current) (f, acc, true)
        else if (expected == current + 1) {
          val newF = (i to n).foldLeft(f)((fAcc, j) => fAcc.updated(j, fAcc(j) + fAcc(j - i)))
          (newF, acc :+ i, true)
        }
        else (f, acc, false)

      case (state, _) => state
    }

    if (!valid) Nil else coins
  }
}
