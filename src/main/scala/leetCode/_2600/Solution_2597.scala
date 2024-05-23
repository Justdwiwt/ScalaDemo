package leetCode._2600

object Solution_2597 {
  def beautifulSubsets(arr: Array[Int], k: Int): Int = {
    f(0, -1, k, arr.sorted, Set.empty[Int]) - 1
  }

  private def f(i: Int, prev_i: Int, k: Int, arr: Array[Int], set: Set[Int]): Int =
    if (i == arr.length) 1
    else {
      val newSet = set + arr(i)
      if (prev_i == -1 || !newSet.contains(arr(i) - k)) f(i + 1, i, k, arr, newSet) + f(i + 1, prev_i, k, arr, set)
      else f(i + 1, prev_i, k, arr, set)
    }
}
