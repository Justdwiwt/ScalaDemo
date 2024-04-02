package leetCode._800

object Solution_786 {
  def kthSmallestPrimeFraction(arr: Array[Int], k: Int): Array[Int] = {
    @scala.annotation.tailrec
    def binarySearch(l: Double, r: Double): Array[Int] = {
      if (true) {
        val mid = (l + r) / 2
        var i = -1
        var cnt = 0
        var x = 0
        var y = 1
        arr.indices.drop(1).foreach(j => {
          while (arr(i + 1).toDouble / arr(j) < mid) {
            i += 1
            if (arr(i) * y > arr(j) * x) {
              x = arr(i)
              y = arr(j)
            }
          }
          cnt += i + 1
        })
        if (cnt == k) Array(x, y)
        else if (cnt < k) binarySearch(mid, r)
        else binarySearch(l, mid)
      } else Array.empty
    }

    binarySearch(0.0, 1.0)
  }
}
