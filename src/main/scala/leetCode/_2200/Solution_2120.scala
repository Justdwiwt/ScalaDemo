package leetCode._2200

object Solution_2120 {
  def executeInstructions(n: Int, startPos: Array[Int], s: String): Array[Int] = s
    .indices
    .map(i => {
      Iterator.iterate((startPos.head, startPos.last, i)) { case (x, y, i) =>
        if (i == s.length) (x, y, i + 1)
        else s(i) match {
          case 'R' => (x, y + 1, i + 1)
          case 'L' => (x, y - 1, i + 1)
          case 'D' => (x + 1, y, i + 1)
          case 'U' => (x - 1, y, i + 1)
        }
      }
        .drop(1)
        .takeWhile { case (x, y, i) => i <= s.length && x >= 0 && x < n && y >= 0 && y < n }
        .size
    }).toArray
}
