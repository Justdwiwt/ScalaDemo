package leetCode._1800

object Solution_1712 {
  def waysToSplit(nums: Array[Int]): Int = {
    val arr = nums.scanLeft(BigInt(0))((s, i) => s + i).drop(1)
    val lower = arr.lastIndexWhere(_ <= arr.last / 3) + 1
    var cnt = BigInt(0)
    var j = 0
    var k = 0
    (0 until lower).foreach(i => {
      j = j.max(i + 1)
      while (j < nums.length - 1 && arr(j) < 2 * arr(i)) j += 1
      k = k.max(j)
      while (k < nums.length - 1 && 2 * arr(k) <= arr(i) + arr.last) k += 1
      cnt += (k - j)
    })
    (cnt % (scala.math.pow(10, 9).toInt + 7)).toInt
  }
}
