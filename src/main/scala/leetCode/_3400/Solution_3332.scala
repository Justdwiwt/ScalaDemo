package leetCode._3400

object Solution_3332 {
  def maxScore(n: Int, k: Int, stayScore: Array[Array[Int]], travelScore: Array[Array[Int]]): Int = {
    val arr = Array.fill(k + 1, n)(0)

    (0 until k).reverse.foreach(i => (0 until n).foreach(j => {
      val stay = arr(i + 1)(j) + stayScore(i)(j)
      val travel = arr(i + 1).zip(travelScore(j)).map { case (fd, ts) => fd + ts }.max
      arr(i)(j) = stay.max(travel)
    }))

    arr.head.max
  }
}
