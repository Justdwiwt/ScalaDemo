package leetCode._800

object Solution_702 {
  abstract class ArrayReader {
    def get(index: Int): Int
  }

  def search(reader: ArrayReader, target: Int): Int = {
    @scala.annotation.tailrec
    def binarySearch(left: Int, right: Int): Int = {
      if (left > right) return -1

      val mid = left + (right - left) / 2
      val midValue = reader.get(mid)

      if (midValue == target) mid
      else if (midValue < target) binarySearch(mid + 1, right)
      else binarySearch(left, mid - 1)
    }

    var size = 1
    while (reader.get(size) < target) size <<= 1

    binarySearch(0, size)
  }
}
