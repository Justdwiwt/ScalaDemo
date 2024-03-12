package leetCode._1000

object Solution_927 {
  def findEndIdx(arr: Array[Int], i: Int, binaryValue: String): Int = {
    if (arr.drop(i).dropWhile(_ == 0).take(binaryValue.length)./:("")((b, a) => a + b) != binaryValue) return -1
    arr.drop(i).takeWhile(_ == 0).length + i + binaryValue.length
  }

  def threeEqualParts(arr: Array[Int]): Array[Int] = {
    val cnt = arr.count(_ == 1)
    val n = arr.length
    if (cnt % 3 != 0) return Array(-1, -1)
    if (cnt == 0) return Array(0, n - 1)
    val idxThird = arr.zipWithIndex.filter(n => n._1 == 1).takeRight(cnt / 3).take(1).head._2
    val binaryValue = arr.takeRight(n - idxThird)./:("")((b, a) => a + b)
    val res1 = findEndIdx(arr, 0, binaryValue)
    if (res1 < 0) return Array(-1, -1)
    val res2 = findEndIdx(arr, res1, binaryValue)
    if (res2 < 0) return Array(-1, -1)
    Array(res1 - 1, res2)
  }
}
