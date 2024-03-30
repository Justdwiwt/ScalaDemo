package leetCode._1100

object Solution_1016 {
  def queryString(S: String, N: Int): Boolean = S
    .indices
    .flatMap(i => (0.max(i - 30) to i).map(j => {
        val v = (j to i).foldLeft(0)((acc, cur) => acc * 2 + S.charAt(cur) - '0')
        (j, v)
      })
      .withFilter { case (_, v) => (v > 0 && v <= N) }
      .map { case (_, v) => v }
    )
    .toSet
    .size == N
}
