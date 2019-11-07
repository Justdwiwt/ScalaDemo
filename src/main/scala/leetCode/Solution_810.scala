package leetCode

object Solution_810 {
  def xorGame(nums: Array[Int]): Boolean = {
    var res = 0
    nums.foreach(i => res ^= i)
    res == 0 || nums.length % 2 == 0
  }
}
