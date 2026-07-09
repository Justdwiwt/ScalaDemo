package leetCode._4000

object Solution_3940 {
  def limitOccurrences(nums: Array[Int], k: Int): Array[Int] =
    nums.foldLeft(Array.empty[Int])((lst, n) => if (lst.count(_ == n) < k) lst :+ n else lst)
}
