package leetCode

object Solution_1679 {
  def maxOperations(nums: Array[Int], k: Int): Int = {
    var m = Map.empty[Int, Int]
    var res = 0
    nums.foreach(n => {
      val cnt = m.getOrElse(k - n, 0)
      if (cnt > 0) {
        res += 1
        m += (k - n) -> (cnt - 1)
      } else m += n -> (m.getOrElse(n, 0) + 1)
    })
    res
  }
}
