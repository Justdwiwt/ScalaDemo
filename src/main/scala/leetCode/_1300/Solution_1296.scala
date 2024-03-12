package leetCode._1300

object Solution_1296 {
  def isPossibleDivide(nums: Array[Int], k: Int): Boolean = {
    if (nums.isEmpty || k < 1 || nums.length % k != 0) return false
    val m = collection.mutable.Map[Int, Int]()
    nums.foreach(n => m += n -> (m.getOrElse(n, 0) + 1))
    val sorted = nums.sorted
    sorted.foreach(n => if (m(n) > 0) (n until n + k).foreach(i => {
      if (!m.contains(i) || m(i) == 0) return false
      m += i -> (m(i) - 1)
    }))
    true
  }
}
