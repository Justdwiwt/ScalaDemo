package leetCode._300

object Solution_280 {
  def wiggleSort(nums: Array[Int]): Unit = {
    val sorted = nums.sorted
    val res = (0 until sorted.length - 1).foldLeft(sorted)((arr, i) => {
      if (i % 2 == 1) arr.updated(i, arr(i + 1)).updated(i + 1, arr(i))
      else arr
    })
    res.indices.foreach(v => nums(v) = res(v))
  }
}
