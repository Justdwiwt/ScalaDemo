package leetCode._3200

object Solution_3181 {
  def maxTotalReward(rewardValues: Array[Int]): Int = {
    val rs = rewardValues.toSet.toArray.sorted
    val f = rs.foldLeft(BigInt(1))((acc, v) => {
      val mask = acc & (BigInt(1) << v) - 1
      acc | (mask << v)
    })
    f.bitLength - 1
  }
}
