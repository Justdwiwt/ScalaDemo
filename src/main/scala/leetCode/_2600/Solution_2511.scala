package leetCode._2600

object Solution_2511 {
  def captureForts(forts: Array[Int]): Int = forts./:(2, 0, 0) { case ((prev, len, prevMax), curr) =>
    if (curr == 0) (prev, len + 1, prevMax)
    else if (prev != curr && prev != 2) (curr, 0, prevMax.max(len))
    else (curr, 0, prevMax)
  }._3
}
