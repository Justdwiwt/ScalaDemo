package leetCode._2100

import scala.math.Integral.Implicits._

object Solution_2028 {
  def missingRolls(rolls: Array[Int], mean: Int, n: Int): Array[Int] = {
    val missingSum = mean * (rolls.length + n) - rolls.sum
    val (quotient, remainder) = missingSum /% n
    if (missingSum < n || missingSum > 6 * n) Array.empty
    else Array.tabulate(n)(i => if (i < remainder) quotient + 1 else quotient)
  }
}
