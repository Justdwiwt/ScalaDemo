package leetCode

object Solution_280 {
  def wiggleSort(nums: Array[Int]): Unit = {
    val sorted = nums.sorted
    (0 until sorted.length - 1).foreach(i => if (i % 2 == 1) {
      val t = sorted(i + 1)
      sorted(i + 1) = sorted(i)
      sorted(i) = t
    })
    nums.indices.foreach(v => nums(v) = sorted(v))
  }
}
