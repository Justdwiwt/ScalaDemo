package leetCode

object Solution_1313 {
  def decompressRLElist(nums: Array[Int]): Array[Int] = {
    nums.grouped(2).flatMap(i => Array.fill(i.head)(i.last)).toArray
  }
}
