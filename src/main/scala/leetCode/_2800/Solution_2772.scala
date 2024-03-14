package leetCode._2800

import scala.collection.mutable

object Solution_2772 {
  def checkArray(nums: Array[Int], k: Int): Boolean = {
    val balances = mutable.ArrayBuffer.empty[Int]
    val balancesPSum = mutable.ArrayBuffer(0)
    nums.indices.foreach(i => {
      val newBalance = nums(i) - balancesPSum(i) + balancesPSum((i - k + 1).max(0))
      balances += newBalance
      balancesPSum += (balancesPSum.last + newBalance)
    })
    balances.forall(_ >= 0) && balances.takeRight(k - 1).forall(_ == 0)
  }
}
