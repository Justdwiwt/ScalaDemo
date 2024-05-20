package leetCode._3200

object Solution_3152 {
  def isArraySpecial(nums: Array[Int], queries: Array[Array[Int]]): Array[Boolean] = {
    val prefixSums = Array.fill(nums.length)(0)

    nums.indices.drop(1).foreach(i => prefixSums(i) = prefixSums(i - 1) + ((nums(i - 1) ^ nums(i) ^ 1) & 1))

    queries.map(query => {
      val from = query.head
      val to = query(1)
      prefixSums(from) == prefixSums(to)
    })
  }
}
