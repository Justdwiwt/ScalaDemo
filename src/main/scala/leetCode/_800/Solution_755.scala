package leetCode._800

object Solution_755 {
  @scala.annotation.tailrec
  def pourWater(heights: Array[Int], times: Int, index: Int): Array[Int] =
    if (times == 0) heights
    else {
      val leftLowestIndex = getLeftLowestIndex(heights, index)
      val rightLowestIndex = getRightLowestIndex(heights, index)

      if (leftLowestIndex != -1) {
        val updatedHeights = heights.updated(leftLowestIndex, heights(leftLowestIndex) + 1)
        pourWater(updatedHeights, times - 1, index)
      } else if (rightLowestIndex != -1) {
        val updatedHeights = heights.updated(rightLowestIndex, heights(rightLowestIndex) + 1)
        pourWater(updatedHeights, times - 1, index)
      } else {
        val updatedHeights = heights.updated(index, heights(index) + 1)
        pourWater(updatedHeights, times - 1, index)
      }
    }

  private def getLeftLowestIndex(heights: Array[Int], index: Int): Int = {
    var height = heights(index)
    var lowestIndex = -1
    var i = index - 1
    while (i >= 0 && heights(i) <= height) {
      if (heights(i) < height) {
        height = heights(i)
        lowestIndex = i
      }
      i -= 1
    }
    lowestIndex
  }

  private def getRightLowestIndex(heights: Array[Int], index: Int): Int = {
    var height = heights(index)
    var lowestIndex = -1
    var i = index + 1
    while (i < heights.length && heights(i) <= height) {
      if (heights(i) < height) {
        height = heights(i)
        lowestIndex = i
      }
      i += 1
    }
    lowestIndex
  }
}
