package leetCode._3500

object Solution_3444 {
  @scala.annotation.tailrec
  private def gcd(a: Long, b: Long): Long = if (b == 0) a else gcd(b, a % b)

  def minimumIncrements(nums: Array[Int], target: Array[Int]): Int = {
    val n = nums.length
    val m = target.length
    val g: Array[Long] = (0 until (1 << m)).map(i => {
      target.indices.foldLeft(1L)((acc, j) => {
        if ((i >> j & 1) == 1) acc / gcd(acc, target(j).toLong) * target(j).toLong
        else acc
      })
    }).toArray

    val INF = 1e18.toLong

    val initialArr = Array.fill(1 << m)(INF)
    initialArr(0) = 0L

    val res = (1 to n).foldLeft(initialArr)((arr, i) => {
      val nextArr = arr.clone()

      (0 until (1 << m)).foreach(j => {
        var k = j
        while (k > 0) {
          val v = (nums(i - 1).toLong + g(k) - 1) / g(k) * g(k) - nums(i - 1)
          nextArr(j) = nextArr(j).min(arr(j ^ k) + v)
          k = (k - 1) & j
        }
      })

      nextArr
    })

    res((1 << m) - 1).toInt
  }
}
