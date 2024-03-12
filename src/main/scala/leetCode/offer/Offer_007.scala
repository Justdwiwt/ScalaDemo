package leetCode.offer

object Offer_007 {
  def threeSum(nums: Array[Int]): List[List[Int]] = {
    val cnt = nums./:(Map.empty[Int, Int].withDefaultValue(0))((c, n) => c + (n -> (c(n) + 1)))
    val uniqueNumbers = cnt.keys.toList.sorted
    uniqueNumbers.flatMap(a => uniqueNumbers
      .withFilter(b => a <= b)
      .withFilter(b => a != b || cnt(a) > 1)
      .map({ b => val c = -a - b; (b, c) })
      .withFilter({ case (b, c) => b <= c })
      .map({ case (b, c) => val candidate = List(a, b, c); (b, c, candidate) })
      .withFilter({ case (_, c, candidate) => cnt(c) >= candidate.count(_ == c) })
      .map({ case (_, _, candidate) => candidate })
    )
  }
}
