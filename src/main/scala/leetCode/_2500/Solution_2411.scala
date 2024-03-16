package leetCode._2500

object Solution_2411 {
  def smallestSubarrays(nums: Array[Int]): Array[Int] = {
    val lastBitPos = nums
      .indices
      .scanRight(Seq.fill(30)(0))((i, pos) => pos.indices.map(bit => if ((nums(i) & 1 << bit) > 0) i else pos(bit)))

    nums
      .indices
      .map(i => (0 until 30)
        .map(lastBitPos(i)(_) - i + 1)
        .max
        .max(1))
      .toArray
  }
}
