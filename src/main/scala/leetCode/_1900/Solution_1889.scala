package leetCode._1900

object Solution_1889 {
  def minWastedSpace(packages: Array[Int], boxes: Array[Array[Int]]): Int = {

    def tripletBinarySearch(x: Array[(Int, Long, Long)], toFind: Long, start: Int): Int = {
      if (toFind >= x.last._2) return x.length - 1

      var (left, middle, right) = (start, (x.length - 1) / 2, x.length - 1)
      var res = -1
      var flag = false

      while (!flag && left <= right) {
        middle = (right - left) / 2 + left
        if (x(middle)._2 == toFind && x(middle + 1)._2 != toFind) {
          flag = true
          res = middle
        } else if (toFind < x(middle)._2) {
          right = middle - 1
          res = right
        } else {
          left = middle + 1
          res = right
        }
      }
      res
    }

    val packagesMax = packages.max
    val firstBoxWaste: Array[(Int, Long, Long)] = packages
      .sorted
      .scanLeft((0L, 0L))((t, pack) => (t._1 + pack, pack))
      .zipWithIndex
      .map(t => (t._2, t._1._2, t._1._2 * t._2 - t._1._1))

    var res = Long.MaxValue

    boxes.foreach(box => if (!(packagesMax > box.max)) {
      val boxesSorted = box.sorted
      var (j, prevBoxIndex, thisResidual: Long) = (0, 0, 0L)
      while (j < box.length) {
        val prevBox = firstBoxWaste(prevBoxIndex)

        val currentBoxIndex = tripletBinarySearch(firstBoxWaste, boxesSorted(j), prevBoxIndex)
        val currentBox = firstBoxWaste(currentBoxIndex)

        val thisWastedSpace: Long = currentBox._3 - prevBox._3 - (currentBox._2 - prevBox._2) * prevBox._1.toLong + (boxesSorted(j).toLong - currentBox._2) * (currentBox._1.toLong - prevBox._1.toLong)
        thisResidual += thisWastedSpace
        prevBoxIndex = currentBoxIndex
        j += 1
      }
      res = res.min(thisResidual)
    })

    if (res == Long.MaxValue) -1 else (res % (math.pow(10, 9).toLong + 7)).toInt
  }
}
