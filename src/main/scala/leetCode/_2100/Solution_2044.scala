package leetCode._2100

object Solution_2044 {
  def countMaxOrSubsets(nums: Array[Int]): Int = {
    val or = nums./:(0)(_ | _)
    (1 until (1 << nums.length)).count(mask => or == nums.indices.filter(i => (mask & (1 << i)) != 0).map(nums)./:(0)(_ | _))
  }
}
