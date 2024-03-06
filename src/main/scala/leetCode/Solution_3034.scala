package leetCode

object Solution_3034 {
  def countMatchingSubarrays(nums: Array[Int], pattern: Array[Int]): Int = nums
    .sliding(pattern.length + 1, 1)
    .map(_.sliding(2))
    .map(_.toList.zip(pattern))
    .count(_.forall(m => (m._2 == 0 && m._1.head == m._1(1)) || (m._2 == 1 && m._1(1) > m._1.head) || m._2 == -1 && m._1.head > m._1(1)))
}
