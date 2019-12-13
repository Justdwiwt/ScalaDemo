package leetCode

object Solution_1010 {
  def numPairsDivisibleBy60(time: Array[Int]): Int = {
    var res = 0
    time.indices.foreach(i => (i + 1 until time.length).foreach(j => if ((time(i) + time(j)) % 60 == 0) res += 1))
    res
  }
}
