package leetCode

object Code_08_03 {
  def findMagicIndex(nums: Array[Int]): Int = {
    nums.indices.foreach(i => if (i == nums(i)) return i)
    -1
  }
}
