package leetCode._3500

object Solution_3485 {
  private def calcLCP(s: String, t: String): Int =
    s.zip(t).takeWhile { case (a, b) => a == b }.length

  private def buildSparseTable(arr: Array[Int]): Array[Array[Int]] = {
    val n = arr.length
    val log = (math.log(n.toDouble) / math.log(2)).toInt + 1
    val st = Array.ofDim[Int](n, log)
    arr.indices.foreach(i => st(i)(0) = arr(i))
    var j = 1
    while ((1 << j) <= n) {
      (0 until n - (1 << j) + 1).foreach(i => st(i)(j) = st(i)(j - 1).min(st(i + (1 << (j - 1)))(j - 1)))
      j += 1
    }
    st
  }

  private def query(l: Int, r: Int, st: Array[Array[Int]]): Int = {
    val len = r - l + 1
    val j = (math.log(len.toDouble) / math.log(2)).toInt
    st(l)(j).min(st(r - (1 << j) + 1)(j))
  }

  def longestCommonPrefix(words: Array[String], k: Int): Array[Int] = {
    val n = words.length
    if (k >= n) Array.fill(n)(0)
    else {
      val idx = words.indices.toArray.sortBy(words(_))
      val lcpAdj = idx.indices.dropRight(1).map(i => calcLCP(words(idx(i)), words(idx(i + 1)))).toArray
      val st = if (lcpAdj.isEmpty) Array.ofDim[Int](0, 0) else buildSparseTable(lcpAdj)
      val windows = (0 to idx.length - k).map(i => if (k == 1) words(idx(i)).length else query(i, i + k - 2, st))
      val (mx, mx2, mxI) = windows.zipWithIndex.foldLeft((-1, -1, -1)) {
        case ((curMx, curMx2, curMxI), (lcp, i)) =>
          if (lcp > curMx) (lcp, curMx, i)
          else if (lcp > curMx2) (curMx, lcp, curMxI)
          else (curMx, curMx2, curMxI)
      }
      val res = Array.fill(n)(mx)
      idx.slice(mxI, mxI + k).foreach(res(_) = mx2)
      res
    }
  }
}
