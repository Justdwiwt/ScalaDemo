package leetCode

object Solution_2568 {
  def minImpossibleOR(nums: Array[Int]): Int = {
    val st = nums.toSet
    (0 to 32).map(i => 1 << i).dropWhile(st.contains).head
  }
}
