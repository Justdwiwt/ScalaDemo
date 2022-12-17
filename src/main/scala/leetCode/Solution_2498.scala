package leetCode

object Solution_2498 {
  def maxJump(stones: Array[Int]): Int = stones
    .indices
    .drop(2)
    ./:(stones(1) - stones.head)((pre, i) => pre.max(stones(i) - stones(i - 2)))
}
