package leetCode._3600

object Solution_3503 {
  def longestPalindrome(s: String, t: String): Int = {
    def isPalindrome(str: String): Boolean =
      str == str.reverse

    (0 to s.length).flatMap(i =>
      (0 to t.length).flatMap(j =>
        (i to s.length).flatMap(k =>
          (j to t.length)
            .withFilter(k > i || _ > j)
            .map { l => val subStr = s.substring(i, k) + t.substring(j, l); (l, subStr) }
            .withFilter { case (_, subStr) => isPalindrome(subStr) }
            .map { case (_, subStr) => subStr.length }
        )
      )
    ).foldLeft(1)(_.max(_))
  }
}
