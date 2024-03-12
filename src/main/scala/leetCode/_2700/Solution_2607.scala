package leetCode._2700

import scala.math.Integral.Implicits._

object Solution_2607 {
  def makeSubKSumEqual(arr: Array[Int], k: Int): Long = {
    val groupSize = gcd(k, arr.length)
    (0 until groupSize)./:(0L)((res, i) => {
      val group = (i until arr.length by groupSize).map(arr.apply).sorted
      val median = group(group.length / 2)
      res + group.map(v => (median - v).abs.toLong).sum
    })

  }

  @scala.annotation.tailrec
  private def gcd[T: Integral](a: T, b: T): T =
    if (b == 0) a else gcd(b, a % b)
}
