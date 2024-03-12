package leetCode._1900

object Solution_1846 {
  def maximumElementAfterDecrementingAndRearranging(arr: Array[Int]): Int = {
    val sorted = arr.sorted
    sorted(0) = 1
    var t = 0
    arr.indices.drop(1).foreach(i => if (sorted(i) != sorted(i - 1)) {
      sorted(i) = sorted(i - 1) + 1
      t += 1
    })
    1 + t
  }
}
