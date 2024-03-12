package leetCode._1200

object Solution_1163 {
  def lastSubstring(s: String): String = {
    var mxV = s.head - 'a'
    var mxIdx = 0
    s.indices.drop(1).foreach(i => {
      val c = s(i)
      if (c - 'a' > mxV) {
        mxV = c - 'a'
        mxIdx = i
      } else if (c - 'a' == mxV) {
        val idx = getMxIdx(mxIdx, i, s)
        if (idx == -1) return s.substring(mxIdx)
        mxIdx = idx
      }
    })
    s.substring(mxIdx)
  }

  def getMxIdx(cur: Int, idx: Int, s: String): Int = {
    var i = 1
    while (idx + i < s.length) {
      if (s(cur + i) > s(idx + i)) return cur
      else if (s(cur + i) < s(idx + i)) return idx
      else i += 1
    }
    -1
  }
}
