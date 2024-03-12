package leetCode._2200

object Solution_2148 {
  def countElements(nums: Array[Int]): Int = {
    lazy val sorted = nums.toList.sorted
    sorted.dropWhile(_ == sorted.head).count(_ != sorted.last)
  }
}
