package leetCode._3800

object Solution_3799 {
  def wordSquares(words: Array[String]): List[List[String]] = {
    val sorted = words.toList.sorted
    sorted.flatMap(top => sorted
      .withFilter(left => left != top && left(0) == top(0))
      .flatMap(left => sorted
        .withFilter(right => right != top && right != left && right(0) == top(3))
        .flatMap(right => sorted
          .withFilter(bottom => bottom != top && bottom != left && bottom != right && bottom(0) == left(3) && bottom(3) == right(3))
          .map(bottom => List(top, left, right, bottom))
        )
      )
    )
  }
}
