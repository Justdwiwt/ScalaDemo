package leetCode._2600

object Solution_2513 {
  def minimizeSet(divisor1: Int, divisor2: Int, uniqueCnt1: Int, uniqueCnt2: Int): Int = {
    val max1 = uniqueCnt1 + (uniqueCnt1 - 1) / (divisor1 - 1)
    val max2 = uniqueCnt2 + (uniqueCnt2 - 1) / (divisor2 - 1)
    val lcm = (divisor2.toLong / gcd(divisor1, divisor2)) * divisor1
    val max3 = (uniqueCnt1 + uniqueCnt2 + (uniqueCnt1 + uniqueCnt2 - 1) / (lcm - 1)).toInt
    max3.max(max1).max(max2)
  }

  @scala.annotation.tailrec
  private def gcd(divisor1: Int, divisor2: Int): Int =
    if (divisor2 == 0) divisor1 else gcd(divisor2, divisor1 % divisor2)
}
