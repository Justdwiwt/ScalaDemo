package leetCode._900

object Solution_830 {
  def largeGroupPositions(S: String): List[List[Int]] = S
    ./:(List.empty[List[Int]]) {
      case (r@List(i1, i2) +: t, c) =>
        if (c == S(i1)) List(i1, i2 + 1) +: t
        else List(i2 + 1, i2 + 1) +: r
      case _ => List(List(0, 0))
    }
    .collect { case l@List(i1, i2) if i2 - i1 > 1 => l }
    .reverse
}
