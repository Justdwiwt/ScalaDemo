package leetCode._200

object Solution_189 {
  def rotate(nums: Array[Int], k: Int): Unit = {
    val M = k % nums.length
    val arr = nums.takeRight(M) ++ nums.take(nums.length - M)
    arr.zipWithIndex.foreach(x => nums(x._2) = x._1)
  }
}
