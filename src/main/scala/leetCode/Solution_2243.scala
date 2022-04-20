package leetCode

object Solution_2243 {
  def digitSum(s: String, k: Int): String = Iterator
    .iterate(s)(_.grouped(k).map(_.map(_ - '0').sum).mkString)
    .dropWhile(_.length > k)
    .next()
}
