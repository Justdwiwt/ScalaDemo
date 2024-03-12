package leetCode._1100

object Solution_1010 {
  def numPairsDivisibleBy60(time: Array[Int]): Int = {
    var res = 0
    val arr = Array.fill(60)(0)
    time.foreach(i => {
      val idx = i % 60
      if (idx != 0) res += arr(60 - idx)
      else res += arr(idx)
      arr(idx) += 1
    })
    res
  }
}
