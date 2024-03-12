package leetCode._2300

object Solution_2229 {
  def isConsecutive(nums: Array[Int]): Boolean = {
    val sorted = nums.sorted
    nums.indices.dropRight(1).foreach(i => if (sorted(i) + 1 != sorted(i + 1)) return false)
    true
  }
}
