package leetCode._2000

object Solution_1987 {
  def numberOfUniqueGoodSubsequences(binary: String): Int = {
    val M = 1000000007
    val res = binary.foldLeft((0, 0, 0))((res, cur) => {
      if (cur == '1') (res._1, (res._2 + res._1 + 1) % M, res._3)
      else ((res._1 + res._2) % M, res._2, 1)
    })
    (res._2 + res._1 + res._3) % M
  }
}
