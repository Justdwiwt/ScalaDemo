package leetCode._3900

object Solution_3862 {
  def smallestBalancedIndex(nums: Array[Int]): Int = {

    @scala.annotation.tailrec
    def loop(l: Int, r: Int, pre: BigInt, mul: BigInt): Int =
      if (l >= r || mul > BigInt(1e14.toLong)) {
        if (pre == mul) l else -1
      } else if (pre < mul) loop(l + 1, r, pre + nums(l), mul)
      else loop(l, r - 1, pre, mul * nums(r))

    loop(0, nums.length - 1, BigInt(0), BigInt(1))
  }
}
