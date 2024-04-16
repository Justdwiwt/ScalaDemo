package leetCode._2900

object Solution_2847 {
  def smallestNumber(n: Long): String = {
    val cnt = Array.fill(10)(0)
    var num = n

    (9 to 2 by -1).foreach(i => Iterator
      .continually(num % i == 0)
      .takeWhile(_ == true)
      .foreach(_ => {
        num /= i
        cnt(i) += 1
      }))

    if (num > 1) "-1"
    else {
      val res = (2 to 9).map(i => i.toString * cnt(i)).mkString
      if (res.nonEmpty) res else "1"
    }
  }
}
