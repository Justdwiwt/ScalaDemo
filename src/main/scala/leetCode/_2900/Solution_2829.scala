package leetCode._2900

object Solution_2829 {
  def minimumSum(n: Int, k: Int): Int =
    f(1, Set.empty, k).take(n).sum

  private def f(i: Int, wrongSet: Set[Int], k: Int): Iterator[Int] =
    if (wrongSet.contains(i)) f(i + 1, wrongSet, k)
    else Iterator(i) ++ f(i + 1, wrongSet + (k - i), k)
}
