package leetCode._3900

object Solution_3840 {
  def rob(nums: Array[Int], colors: Array[Int]): Long = nums.headOption match {
    case None => 0L
    case Some(first) => nums.indices.drop(1).foldLeft((0L, first.toLong)) {
      case ((prevNot, prevTake), i) =>
        if (colors(i) != colors(i - 1)) (prevTake, prevTake + nums(i))
        else (prevTake, (prevNot + nums(i)).max(prevTake))
    }._2
  }
}
