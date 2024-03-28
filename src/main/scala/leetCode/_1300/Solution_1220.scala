package leetCode._1300

object Solution_1220 {
  def countVowelPermutation(n: Int): Int = {
    @scala.annotation.tailrec
    def f(n: Int, acc: (BigInt, BigInt, BigInt, BigInt, BigInt)): BigInt = n match {
      case 1 => acc._1 + acc._2 + acc._3 + acc._4 + acc._5
      case _ => f(n - 1, (acc._2 + acc._3 + acc._5, acc._1 + acc._3, acc._2 + acc._4, acc._3, acc._3 + acc._4))
    }

    (f(n, (1, 1, 1, 1, 1)) % 1000000007.toLong).toInt
  }
}
