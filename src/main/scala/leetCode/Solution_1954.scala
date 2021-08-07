package leetCode

object Solution_1954 {
  def minimumPerimeter(neededApples: Long): Long = {
    @scala.annotation.tailrec
    def f(size: Int, arrWidth: Int, arrSum: Long, arrTop: Int, prev: Long): Long = {
      val nArrSum = arrSum + arrWidth + (arrTop + 1) + (arrTop + 2)
      val acc = prev + 4 * arrSum
      if (acc >= neededApples) size
      else f(size + 1, arrWidth + 2, nArrSum, arrTop + 2, acc)
    }

    8 * f(1, 2, 3, 2, 0)
  }
}
