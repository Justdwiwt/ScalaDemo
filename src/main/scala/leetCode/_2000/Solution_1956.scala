package leetCode._2000

object Solution_1956 {
  // fixme: case 15/70 wrong answer
  def minDayskVariants(points: Array[Array[Int]], k: Int): Int = {
    val N = points.length
    var res = Int.MaxValue
    val nPoints = Array.ofDim[Int](k, 2)
    val distX = Array.fill(k)(0)
    val start = (1 << k) - 1
    val end = (1 << N) - (1 << (N - k))
    var x1 = 1000000000
    var y1 = 1000000000
    var x2 = 1
    var y2 = 1

    points.indices.foreach(i => {
      x1 = x1.min(points(i).head)
      x2 = x2.max(points(i).head)
      y1 = y1.min(points(i)(1))
      y2 = y2.max(points(i)(1))
    })

    (start to end).foreach(i => {
      if (count(i, N, k) != k) ()
      val digit = i
      var idx = 0
      points.indices.foreach(j => if (((1 << j) & digit) != 0) {
        nPoints(idx) = points(j)
        idx += 1
      })
      val a = prob(nPoints)
      var tmp1 = a / 2
      if (a % 2 == 1) tmp1 += 1
      if (tmp1 > res) ()
      val tmp = dist2(nPoints, distX, x1, x2, y1, y2)
      if (res > tmp) res = tmp
    })
    res
  }

  private def prob(points: Array[Array[Int]]): Int = {
    var res = 0
    points.indices.foreach(i => (i + 1 until points.length).foreach(j => {
      val tmp = (points(i).head - points(j).head).abs + (points(i)(1) - points(j)(1)).abs
      if (res < tmp) res = tmp
    }))
    res
  }

  private def dist2(points: Array[Array[Int]], distX: Array[Int], x1: Int, x2: Int, y1: Int, y2: Int): Int = {
    var left = x1
    var right = x2
    var res = Int.MaxValue
    while (left <= right) {
      val mid = (left + right) >> 1
      val mmid = (mid + right) >> 1
      val md = dist1(points, mid, y1, y2, distX)
      val mmd = dist1(points, mmid, y1, y2, distX)
      if (md >= mmd) {
        if (res > mmd) res = mmd
        left = mid + 1
      } else {
        if (res > md) res = md
        right = mmid - 1
      }
    }
    res
  }

  private def dist1(points: Array[Array[Int]], x: Int, y1: Int, y2: Int, distX: Array[Int]): Int = {
    var left = y1
    var right = y2
    var res = Int.MaxValue
    points.indices.foreach(i => distX(i) = (x - points(i).head).abs)
    while (left <= right) {
      val mid = (left + right) / 2
      val mmid = (mid + right) / 2
      val md = dist(points, distX, mid)
      val mmd = dist(points, distX, mmid)
      if (md >= mmd) {
        left = mid + 1
        if (res > mmd) res = mmd
      } else {
        right = mmid - 1
        if (res > md) res = md
      }
    }
    res
  }

  private def dist(points: Array[Array[Int]], distX: Array[Int], y: Int): Int = {
    var min = 0
    points.indices.foreach(i => {
      val t = distX(i) + (points(i)(1) - y).abs
      if (min < t) min = t
    })
    min
  }

  private def count(digit: Int, N: Int, k: Int): Int = {
    var cnt = 0
    var i = 0
    while (i < N) {
      if (((1 << i) & digit) != 0) {
        cnt += 1
        if (cnt > k) return cnt
      }
      i += 1
    }
    cnt
  }
}
