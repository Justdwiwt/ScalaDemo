package leetCode

object Solution_2048 {
  def nextBeautifulNumber(n: Int): Int = {
    val nums = (1 to 3).flatMap(take => Array
      .range(1, 8)
      .combinations(take)
      .withFilter(comb => comb.sum <= 7)
      .flatMap(comb => comb
        .flatMap(i => Array.fill(i)(i))
        .permutations
        .map({ perm => val num = perm./:(0)(_ * 10 + _); (perm, num) })
        .withFilter({ case (_, num) => num > n })
        .map({ case (_, num) => num })
      )
    )
    nums.min
  }
}
