package leetCode._2600

object Solution_2600 {
  def kItemsWithMaximumSum(numOnes: Int, numZeros: Int, numNegOnes: Int, k: Int): Int =
    (Array.fill(numOnes)(1) ++ Array.fill(numZeros)(0) ++ Array.fill(numNegOnes)(-1)).take(k).sum
}
