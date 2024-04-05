package leetCode._500

object Solution_467 {
  def findSubstringInWraproundString(p: String): Int = p.indices.foldLeft(Seq.fill(26)(0), 0) {
    case ((mx, cur), i) =>
      val idx = p(i) - 'a'
      val pre = p(Math.floorMod(i - 1, p.length)) - 'a'
      val isConsecutive = Math.floorMod(idx - pre, 26) == 1
      val newCur = if (isConsecutive) cur + 1 else 1
      val newMx = mx.updated(idx, newCur.max(mx(idx)))
      (newMx, newCur)
  }._1.sum
}
