package leetCode._3600

object Solution_3551 {
  def minSwaps(nums: Array[Int]): Int = {
    val sorted = nums
      .zipWithIndex
      .map { case (num, idx) =>
        val digitSum = num.toString.map(_ - '0').sum
        (digitSum, num, idx)
      }
      .sortBy { case (digitSum, num, _) => (digitSum, num) }
    val posMap = sorted
      .zipWithIndex
      .map { case ((_, _, originalIdx), sortedIdx) => originalIdx -> sortedIdx }
      .toMap

    def countCycles(visited: Set[Int], idx: Int, acc: Int): (Set[Int], Int) =
      if (visited.contains(idx) || posMap(idx) == idx) (visited, acc)
      else {
        @scala.annotation.tailrec
        def loop(current: Int, count: Int, seen: Set[Int]): (Set[Int], Int) =
          if (seen.contains(current)) (seen, count)
          else {
            val next = posMap(current)
            loop(next, count + 1, seen + current)
          }

        val (newVisited, cycleSize) = loop(idx, 0, visited)
        (newVisited, acc + (cycleSize - 1))
      }

    nums
      .indices
      .foldLeft((Set.empty[Int], 0)) {
        case ((visited, acc), i) =>
          val (newVisited, newAcc) = countCycles(visited, i, acc)
          (newVisited, newAcc)
      }
      ._2
  }
}
