package leetCode._1000

object Solution_997 {
  def findJudge(N: Int, trust: Array[Array[Int]]): Int = {
    val arr = Array.ofDim[Int](N + 1)
    trust.foreach { case Array(i, j) =>
      arr(i) -= 1
      arr(j) += 1
    }
    arr
      .zipWithIndex
      .tail
      .find(_._1 == N - 1)
      .map(_._2)
      .getOrElse(-1)
  }
}
