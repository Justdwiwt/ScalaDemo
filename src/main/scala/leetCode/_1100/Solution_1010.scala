package leetCode._1100

object Solution_1010 {
  def numPairsDivisibleBy60(time: Array[Int]): Int = time.foldLeft(new Array[Int](60), 0)((b, a) => {
    val t = b._2 + b._1((60 - a % 60) % 60)
    b._1(a % 60) = b._1(a % 60) + 1
    (b._1, t)
  })._2
}
