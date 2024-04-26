package leetCode._2000

object Solution_1966 {
  def binarySearchableNumbers(nums: Array[Int]): Int = {
    val n = nums.length
    var l = Int.MinValue
    var r = Int.MaxValue
    val has = Array.fill(n)(0)

    nums.indices.foreach(i => {
      val j = n - 1 - i
      val vi = nums(i)
      val vj = nums(j)

      if (vi > l) {
        l = vi
        has(i) += 1
      }
      if (vj < r) {
        r = vj
        has(j) += 1
      }
    })

    has.count(_ == 2)
  }
}
