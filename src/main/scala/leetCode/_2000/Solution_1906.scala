package leetCode._2000

object Solution_1906 {
  def minDifference(nums: Array[Int], queries: Array[Array[Int]]): Array[Int] = {
    val arr = Array.ofDim[Int](nums.length, 101)
    arr.head(nums.head) = 1
    nums.indices.drop(1).foreach(i => {
      (1 until 101).foreach(j => arr(i)(j) = arr(i - 1)(j))
      arr(i)(nums(i)) += 1
    })
    queries.map(q => {
      val l = q.head
      val r = q(1)
      var first, second = -1
      var mn = Int.MaxValue
      (1 until 101)
        .filter(i => (arr(r)(i) - (if (l == 0) 0 else arr(l - 1)(i))) > 0)
        .foreach(i =>
          if (first == -1) first = i
          else {
            second = i
            mn = mn.min(second - first)
            first = second
          }
        )
      if (mn == Int.MaxValue) -1 else mn
    })
  }
}
