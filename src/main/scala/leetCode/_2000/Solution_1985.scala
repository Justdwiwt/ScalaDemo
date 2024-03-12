package leetCode._2000

object Solution_1985 {
  def kthLargestNumber(nums: Array[String], k: Int): String =
    nums.sortWith((s1: String, s2: String) => if (s1.length == s2.length) s1 > s2 else s1.length > s2.length)(k - 1)
}
