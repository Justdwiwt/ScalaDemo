package leetCode

object Solution_2156 {
  def subStrHash(s: String, power: Int, mod: Int, k: Int, targetHash: Int): String = {
    val value = (i: Int) => s(i) - '`'
    val len = s.length
    val powK = (1 to k)./:(1L)((powK, _) => powK * power % mod)

    val initHash = (len - k until len).:\(0L)((i, hash) => (hash * power + value(i)) % mod)
    val initStart = if (initHash == targetHash) len - k else len

    val (_, start) = (0 until len - k).:\(initHash, initStart) { case (i, (prevHash, start)) =>
      val expandedHash = (prevHash * power + value(i)) % mod
      val shrunkHash = expandedHash - value(i + k) * powK % mod
      val newHash = java.lang.Math.floorMod(shrunkHash, mod)
      val newStart = if (newHash == targetHash) i else start
      (newHash, newStart)
    }

    s.substring(start, start + k)
  }
}
