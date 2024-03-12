package leetCode._600

object Solution_523 {
  def checkSubarraySum(nums: Array[Int], k: Int): Boolean = {
    @scala.annotation.tailrec
    def f(num: List[Int], m: Map[Int, Int], idx: Int, prev: Int): Boolean = num match {
      case Nil => false
      case head :: tail =>
        val curr = if (k == 0) prev + head else (prev + head) % k
        if (m.contains(curr))
          if (idx - m(curr) > 1) true
          else f(tail, m, idx + 1, curr)
        else f(tail, m + (curr -> idx), idx + 1, curr)
    }

    f(nums.toList, Map(0 -> -1), 0, 0)
  }
}
