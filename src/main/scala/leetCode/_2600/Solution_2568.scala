package leetCode._2600

object Solution_2568 {
  def minImpossibleOR(nums: Array[Int]): Int = {
    val st = nums.toSet
    (0 to 32).map(1 << _).dropWhile(st.contains).head
  }
}
