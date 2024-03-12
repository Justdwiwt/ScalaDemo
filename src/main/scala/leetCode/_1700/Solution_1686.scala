package leetCode._1700

object Solution_1686 {
  def stoneGameVI(aliceValues: Array[Int], bobValues: Array[Int]): Int = {
    val values = aliceValues.zip(bobValues).sortBy(x => -(x._1 + x._2))
    var alice = 0
    var bob = 0
    values.indices.foreach(i => {
      val (a, b) = values(i)
      if (i % 2 == 0) alice += a
      else bob += b
    })
    if (alice > bob) 1
    else if (alice < bob) -1
    else 0
  }
}
