package leetCode._3000

import scala.collection.mutable

object Solution_2992 {
  def selfDivisiblePermutationCount(n: Int): Int = {
    @scala.annotation.tailrec
    def gcd(a: Int, b: Int): Int =
      if (b == 0) a else gcd(b, a % b)

    var res = 0
    val st = mutable.Set(1 to n: _*)

    def f(x: Int): Unit =
      if (x == 0) res += 1
      else {
        val tmp = st.filter(gcd(x, _) == 1).toList
        tmp.foreach(i => {
          st.remove(i)
          f(x - 1)
          st.add(i)
        })
      }

    f(n)
    res
  }
}
