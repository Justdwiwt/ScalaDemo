package leetCode

object Solution_1295 {
  def findNumbers(nums: Array[Int]): Int = {
    var res = 0
    nums.foreach(i => if (i.toString.length % 2 == 0) res += 1)
    res
  }
}
