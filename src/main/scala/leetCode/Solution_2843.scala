package leetCode

object Solution_2843 {
  def countSymmetricIntegers(low: Int, high: Int): Int = {
    def f(str: String): Boolean = {
      val n = str.length
      n % 2 == 0 && str.take(n / 2).map(_.toInt).sum == str.drop(n / 2).map(_.toInt).sum
    }

    (low to high)
      .withFilter(i => f(i.toString))
      .map(_ => 1).size
  }
}
