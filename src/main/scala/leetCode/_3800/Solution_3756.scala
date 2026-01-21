package leetCode._3800

object Solution_3756 {
  private val M = 1000000007
  private val MAX_N = 100001

  private val pow10: Array[Int] =
    Array.iterate(1, MAX_N)(x => (x.toLong * 10 % M).toInt)

  def sumAndMultiply(s: String, queries: Array[Array[Int]]): Array[Int] = {
    val (sumD, preNum, sumNZ) =
      s.foldLeft((Vector(0), Vector(0), Vector(0))) {
        case ((sd, pn, nz), ch) =>
          val d = ch - '0'
          (
            sd :+ (sd.last + d),
            pn :+ (if (d == 0) pn.last else ((pn.last.toLong * 10 + d) % M).toInt),
            nz :+ (nz.last + (if (d > 0) 1 else 0))
          )
      }

    queries.map { case Array(l, r0) =>
      val r = r0 + 1
      val len = sumNZ(r) - sumNZ(l)
      val x = (preNum(r) - preNum(l).toLong * pow10(len) % M + M) % M

      ((x * (sumD(r) - sumD(l)).toLong) % M).toInt
    }
  }
}
