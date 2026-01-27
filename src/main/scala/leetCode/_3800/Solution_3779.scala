package leetCode._3800

object Solution_3779 {
  def minOperations(nums: Array[Int]): Int = {
    val l = nums.length - nums.foldRight((false, Set.empty[Int])) {
      case (v, (foundDuplicate, set)) =>
        if (!foundDuplicate && !set(v)) (false, set + v)
        else (true, set)
    }._2.size

    if (l % 3 == 0) l / 3 else l / 3 + 1
  }
}
