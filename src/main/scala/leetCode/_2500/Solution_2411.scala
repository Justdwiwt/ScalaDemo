package leetCode._2500

object Solution_2411 {
  def smallestSubarrays(nums: Array[Int]): Array[Int] = {
    val postfix = Array.fill(nums.length)(0)
    postfix(nums.length - 1) = nums.last
    nums.indices.reverse.tail.foreach(i => postfix(i) = postfix(i + 1) | nums(i))
    nums.indices.toArray.map(i => {
      var j = i
      var sum = 0
      while (j < nums.length && sum < postfix(i)) {
        sum |= nums(j)
        j += 1
      }
      1.max(j - i)
    })
  }
}
