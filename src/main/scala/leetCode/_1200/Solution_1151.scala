package leetCode._1200

object Solution_1151 {
  def minSwaps(data: Array[Int]): Int = {
    val ones = data.sum

    @scala.annotation.tailrec
    def findMaxOnes(left: Int, right: Int, cntOne: Int, maxOne: Int): Int =
      if (right == data.length) ones - maxOne
      else {
        val newCntOne = cntOne + data(right)
        val updatedCntOne = if (right - left + 1 > ones) newCntOne - data(left) else newCntOne
        val updatedMaxOne = math.max(maxOne, updatedCntOne)
        findMaxOnes(if (right - left + 1 > ones) left + 1 else left, right + 1, updatedCntOne, updatedMaxOne)
      }

    findMaxOnes(0, 0, 0, 0)
  }
}
