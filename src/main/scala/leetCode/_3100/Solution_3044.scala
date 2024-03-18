package leetCode._3100

object Solution_3044 {
  def mostFrequentPrime(mat: Array[Array[Int]]): Int = {
    val startStates = mat
      .indices
      .flatMap(r => mat(r).indices.flatMap(c => (-1 to 1).flatMap(dr => (-1 to 1)
        .withFilter(dr != 0 || _ != 0)
        .map((r, c, dr, _)))))

    val nums = startStates.flatMap { case (r, c, dr, dc) =>
      Iterator
        .iterate((r, c)) { case (r, c) => (r + dr, c + dc) }
        .takeWhile { case (r, c) => r >= 0 && r < mat.length && c >= 0 && c < mat(r).length }
        .scanLeft(0) { case (num, (r, c)) => num * 10 + mat(r)(c) }
    }

    val t = nums
      .groupBy(identity)
      .mapValues(_.length)
      .filter { case (num, _) => isPrime(num) }

    if (t.nonEmpty) t
      .maxBy { case (num, cnt) => (cnt, num) }
      ._1
    else -1
  }

  private def isPrime(n: Int): Boolean =
    n > 10 && n % 2 != 0 && (3 to math.sqrt(n).toInt by 2).forall(n % _ != 0)
}
