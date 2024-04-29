package leetCode._1600

object Solution_1533 {
  abstract class ArrayReader {
    // Compares the sum of arr[l..r] with the sum of arr[x..y]
    // return 1 if sum(arr[l..r]) > sum(arr[x..y])
    // return 0 if sum(arr[l..r]) == sum(arr[x..y])
    // return -1 if sum(arr[l..r]) < sum(arr[x..y])
    def compareSub(l: Int, r: Int, x: Int, y: Int): Int

    // Returns the length of the array
    def length(): Int
  }

  def getIndex(reader: ArrayReader): Int = {
    val n = reader.length()
    f(0, n / 2 - 1, n - n / 2, n - 1, reader)
  }

  @scala.annotation.tailrec
  private def f(l: Int, r: Int, x: Int, y: Int, reader: ArrayReader): Int = reader.compareSub(l, r, x, y) match {
    case v if v > 0 =>
      if (l == r) l
      else {
        val length = r - l + 1
        f(l, l + length / 2 - 1, r - length / 2 + 1, r, reader)
      }
    case v if v < 0 =>
      if (x == y) x
      else {
        val length = y - x + 1
        f(x, x + length / 2 - 1, y - length / 2 + 1, y, reader)
      }
    case _ => r + 1
  }
}
