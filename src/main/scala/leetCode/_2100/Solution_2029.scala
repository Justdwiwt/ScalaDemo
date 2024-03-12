package leetCode._2100

object Solution_2029 {
  def stoneGameIX(stones: Array[Int]): Boolean = {
    val diff = Array.ofDim[Int](3)
    stones.foreach(stone => diff(stone % 3) += 1)
    if (diff.head % 2 == 0) diff(1) > 0 && diff(2) > 0
    else (diff(1) - diff(2)).abs > 2
  }
}
