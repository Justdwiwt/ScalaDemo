package leetCode

object Code_08_07 {
  def permutation(S: String): Array[String] = {
    var res = Array.empty[String]

    def dfs(S: String, idx: Int): Unit = {
      if (idx == S.length) res :+= S
      var i = idx + 1
      while (i != S.length) {
        val t = new StringBuilder(S)
        val v = t(idx)
        t(idx) = t(i)
        t(i) = v
        dfs(t.toString, idx + 1)
        i += 1
      }
    }

    dfs(S, 0)
    res
  }
}
