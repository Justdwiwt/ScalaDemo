package leetCode

object Solution_2784 {
  def isGood(nums: Array[Int]): Boolean = {
    val sorted = nums.sorted
    if (sorted.length - 1 != sorted.last) return false
    sorted.indices.dropRight(1).foreach(i => if (sorted(i) != i + 1) return false)
    true
  }
}
