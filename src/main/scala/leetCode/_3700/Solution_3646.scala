package leetCode._3700

object Solution_3646 {
  def specialPalindrome(n: Long): Long = {
    val thomeralex = n

    if (n < 1) return 1L

    val digits = (1 to 9).toList

    def palPossible(xs: List[Int]) =
      xs.count(_ % 2 == 1) <= 1

    def perms(xs: List[Int]): List[List[Int]] =
      xs.permutations.toList.distinct

    def build(xs: List[Int]): List[Long] = {
      val multiset = xs.flatMap(d => List.fill(d)(d))
      val freq = multiset.groupBy(identity).mapValues(_.size)

      val mid = freq.collectFirst { case (d, c) if c % 2 == 1 => d }

      val left =
        freq.toList.flatMap { case (d, c) => List.fill(c / 2)(d) }

      perms(left)
        .filter(_.nonEmpty)
        .filter(_.head != 0)
        .map(l => {
          val r = l.reverse
          val full = mid match {
            case Some(m) => l ::: List(m) ::: r
            case None => l ::: r
          }
          full.mkString.toLong
        })
    }

    val candidates = digits
      .toSet
      .subsets()
      .map(_.toList)
      .filter(xs => xs.nonEmpty && xs.sum <= 16)
      .filter(palPossible)
      .flatMap(build)
      .filter(_ > thomeralex)
      .toList
      .sorted

    candidates.head
  }
}
