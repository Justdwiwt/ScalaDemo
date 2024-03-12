package leetCode._2300

object Solution_2271 {
  def maximumWhiteTiles(tiles: Array[Array[Int]], carpetLen: Int): Int = {
    val sorted = tiles.sortBy(_.head)
    val sz = sorted.map(t => t(1) - t.head + 1)
    val szs = sz.clone()
    sz.indices.drop(1).foreach(i => szs(i) += szs(i - 1))

    @scala.annotation.tailrec
    def find(pos: Int, l: Int, r: Int): Int =
      if (l == r) l
      else {
        val mid = (l + r) >>> 1
        if (sorted(mid)(1) < pos) find(pos, mid + 1, r)
        else find(pos, l, mid)
      }

    var res = 0
    sorted.indices.foreach(i => {
      val lPos = sorted(i)(1) - carpetLen + 1
      val l = find(lPos, 0, sorted.length)
      var sum = szs(i) - szs(l)
      if (sorted(l).head >= lPos) sum += sz(l)
      else sum += sorted(l)(1) - lPos + 1
      res = res.max(sum)
    })
    res
  }
}
