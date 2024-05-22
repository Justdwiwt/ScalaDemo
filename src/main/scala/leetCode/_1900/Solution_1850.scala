package leetCode._1900

object Solution_1850 {
  def getMinSwaps(num: String, k: Int): Int = {
    val ch = num.toCharArray
    (0 until k).foreach(_ => nextPermutation(ch))

    val n = num.length
    val mapIdx = Array.ofDim[Int](n)
    val digitCnt = Array.fill(10)(0)

    num.indices.foreach(i => {
      val x = num(i) - '0'
      digitCnt(x) += 1
      var y = digitCnt(x)
      var found = false
      (0 until n)
        .withFilter(_ => !found)
        .foreach(j => if (ch(j) - '0' == x) {
          y -= 1
          if (y == 0) {
            mapIdx(i) = j
            found = true
          }
        })
    })

    var cnt = 0
    num.indices.foreach(i => (i + 1 until n).foreach(j => if (mapIdx(i) > mapIdx(j)) cnt += 1))
    cnt
  }

  private def nextPermutation(arr: Array[Char]): Unit = {
    def swap(i: Int, j: Int): Unit = {
      val temp = arr(i)
      arr(i) = arr(j)
      arr(j) = temp
    }

    def reverse(start: Int): Unit = {
      var i = start
      var j = arr.length - 1
      while (i < j) {
        swap(i, j)
        i += 1
        j -= 1
      }
    }

    var i = arr.length - 2

    while (i >= 0 && arr(i) >= arr(i + 1)) i -= 1

    if (i >= 0) {
      var j = arr.length - 1
      while (arr(j) <= arr(i)) j -= 1
      swap(i, j)
    }

    reverse(i + 1)
  }
}
