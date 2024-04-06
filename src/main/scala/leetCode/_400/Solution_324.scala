package leetCode._400

object Solution_324 {
  def wiggleSort(nums: Array[Int]): Unit = nums
    .sorted
    .zipWithIndex
    .foreach(t => nums(f(nums.length, t._2)) = t._1)

  private def f(len: Int, index: Int): Int =
    if (index > (len - 1) / 2) (len - 1 - index) * 2 + 1
    else ((len - 1) / 2 - index) * 2
}
