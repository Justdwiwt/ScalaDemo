package leetCode._2600

object Solution_2588 {
  def beautifulSubarrays(nums: Array[Int]): Long =
    nums.foldLeft((0, 0L, Map[Int, Long](0 -> 1))) {
      case ((s, ans, cnt), x) =>
        val newS = s ^ x
        val newAns = ans + cnt.getOrElse(newS, 0L)
        val newCnt = cnt + (newS -> (cnt.getOrElse(newS, 0L) + 1))
        (newS, newAns, newCnt)
    }._2
}
