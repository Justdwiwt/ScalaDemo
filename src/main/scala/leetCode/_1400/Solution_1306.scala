package leetCode._1400

object Solution_1306 {
  @scala.annotation.tailrec
  def f(arr: Array[Int], target: Array[Int], visited: Set[Int], toVisit: Array[Int]): Boolean =
    if (target.exists(visited.contains)) true
    else if (toVisit.isEmpty && !target.exists(visited.contains)) false
    else f(
      arr,
      target,
      visited ++ toVisit,
      toVisit
        .flatMap(cur => Array(cur - arr(cur), cur + arr(cur)))
        .filterNot(visited.contains)
        .filter(idx => idx < arr.length && idx >= 0)
    )

  def canReach(arr: Array[Int], start: Int): Boolean =
    f(arr, arr.zipWithIndex.withFilter(_._1 == 0).map(_._2), Set.empty, Array(start))
}
