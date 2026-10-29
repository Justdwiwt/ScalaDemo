package leetCode._4100

object Solution_4034 {
  def minBishopMoves(source: Array[Int], target: Array[Int]): Int = {
    if ((source.sum - target.sum) % 2 != 0) -1
    else if (source(0) == target(0) && source(1) == target(1)) 0
    else if (math.abs(source(0) - target(0)) == math.abs(source(1) - target(1))) 1
    else 2
  }
}
