package leetCode._3300

import scala.collection.mutable.ArrayBuffer
import scala.util.Sorting

object Solution_3288 {
  def maxPathLength(coordinates: Array[Array[Int]], k: Int): Int = {
    val (ncx, ncy) = (coordinates(k).head, coordinates(k)(1))
    val n = coordinates.length

    Sorting.quickSort(coordinates)(Ordering.fromLessThan((a, b) => if (a.head == b.head) b(1) < a(1) else a.head < b.head))

    val (coordinates1, coordinates2) = coordinates.foldLeft((ArrayBuffer.empty[Int], ArrayBuffer.empty[Int])) {
      case ((left, right), Array(x, y)) =>
        if (x < ncx && y < ncy) (left += y, right)
        else if (x > ncx && y > ncy) (left, right += y)
        else (left, right)
    }

    val dp = Array.ofDim[Int](n)

    val size1 = cal(coordinates1.toArray, dp)
    val size2 = cal(coordinates2.toArray, dp)

    size1 + size2 + 1
  }

  private def cal(coordinates: Array[Int], dp: Array[Int]): Int = {
    var size = 0
    coordinates.foreach(y => {
      val pos = java.util.Arrays.binarySearch(dp, 0, size, y)
      val insertPos = if (pos < 0) -(pos + 1) else pos
      dp(insertPos) = y
      if (insertPos == size) size += 1
    })
    size
  }
}
