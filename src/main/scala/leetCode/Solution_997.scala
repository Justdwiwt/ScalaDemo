package leetCode

object Solution_997 {
  def findJudge(N: Int, trust: Array[Array[Int]]): Int = {
    val people = Array.ofDim[Int](N, 2)
    trust.foreach(p => {
      people(p(0) - 1)(0) += 1
      people(p(1) - 1)(1) += 1
    })
    (0 until N).foreach(i => if (people(i)(0) == 0 && people(i)(1) == N - 1) return i + 1)
    -1
  }
}
