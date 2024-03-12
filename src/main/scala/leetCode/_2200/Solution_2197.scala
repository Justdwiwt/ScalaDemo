package leetCode._2200

object Solution_2197 {
  @scala.annotation.tailrec
  def gcd(a: Long, b: Long): Long =
    if (b == 0) a else gcd(b, a % b)

  def replaceNonCoprimes(nums: Array[Int]): List[Int] = {
    def f(l: List[Long], r: List[Long]): List[Int] = {
      l match {
        case one :: two :: rest =>
          val g = gcd(one, two)
          if (g != 1) return f(one * two / g :: rest, r)
        case _ => ()
      }
      r match {
        case head :: tail => f(head :: l, tail)
        case _ => l.map(_.toInt).reverse
      }
    }

    f(Nil, nums.map(_.toLong).toList)
  }
}
