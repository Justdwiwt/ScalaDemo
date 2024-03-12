package leetCode._2800

import scala.collection.mutable

object Solution_2761 {
  def findPrimePairs(n: Int): List[List[Int]] =
    if (n % 2 == 1)
      if (n > 2 && BigInt(n - 2).isProbablePrime(10)) List(List(2, n - 2)) else List()
    else {
      val res = mutable.ListBuffer[List[Int]]()
      (2 to n / 2).foreach(i => if (BigInt(i).isProbablePrime(10) && BigInt(n - i).isProbablePrime(10)) res += List(i, n - i))
      res.toList
    }
}
