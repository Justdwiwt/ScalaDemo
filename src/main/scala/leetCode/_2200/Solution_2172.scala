package leetCode._2200

import scala.collection.mutable

object Solution_2172 {
  def maximumANDSum(nums: Array[Int], numSlots: Int): Int = {
    val m = mutable.Map.empty[(Int, Int), Int]

    def dfs(idx: Int, mask: Int): Int = m.getOrElseUpdate((idx, mask), {
      if (idx == nums.length) 0
      else (0 until numSlots)
        .flatMap(i => Seq(0, 1).collectFirst {
          case posInSlot if (mask & (1 << (2 * i + posInSlot))) == 0 =>
            val newMask = mask | (1 << (2 * i + posInSlot))
            (nums(idx) & (i + 1)) + dfs(idx + 1, newMask)
        })
        .max
    })

    dfs(idx = 0, mask = 0)
  }
}
