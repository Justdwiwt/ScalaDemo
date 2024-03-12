package leetCode._2400

object Solution_2400 {
  def f(n: Int): BigInt = BigInt(1).to(n).product

  def numberOfWays(startPos: Int, endPos: Int, k: Int): Int = {
    val dist = (startPos - endPos).abs
    val possible = k % 2 == dist % 2 && dist <= k
    if (!possible) 0
    else {
      val right = dist + (k - dist) / 2
      val left = k - right
      val kChooseRight = f(k) / (f(right) * f(left))
      (kChooseRight % 1000000007).toInt
    }
  }
}
