package leetCode._1600

object Solution_1515 {
  def getMinDistSum(positions: Array[Array[Int]]): Double = {
    val M = 1e-7

    @scala.annotation.tailrec
    def searchX(xLeft: Double, xRight: Double): Double =
      if (xRight - xLeft <= M) checkOptimal(xLeft, positions, M)
      else {
        val xFirst = (xLeft + xLeft + xRight) / 3
        val xSecond = (xLeft + xRight + xRight) / 3
        if (checkOptimal(xFirst, positions, M) < checkOptimal(xSecond, positions, M)) searchX(xLeft, xSecond)
        else searchX(xFirst, xRight)
      }

    searchX(0.0, 100.0)
  }

  private def getDist(xc: Double, yc: Double, positions: Array[Array[Int]]): Double =
    positions.map(pos => math.sqrt((pos.head - xc) * (pos.head - xc) + (pos(1) - yc) * (pos(1) - yc))).sum

  private def checkOptimal(xc: Double, positions: Array[Array[Int]], eps: Double): Double = {
    @scala.annotation.tailrec
    def searchY(yLeft: Double, yRight: Double): Double =
      if (yRight - yLeft <= eps) getDist(xc, yLeft, positions)
      else {
        val yFirst = (yLeft + yLeft + yRight) / 3
        val ySecond = (yLeft + yRight + yRight) / 3
        if (getDist(xc, yFirst, positions) < getDist(xc, ySecond, positions)) searchY(yLeft, ySecond)
        else searchY(yFirst, yRight)
      }

    searchY(0.0, 100.0)
  }
}
