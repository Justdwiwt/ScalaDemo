package leetCode

object Solution_990 {
  def equationsPossible(equations: Array[String]): Boolean = {
    val diff = Array.fill(26)(0)
    if (equations.isEmpty) return true
    (0 until 26).foreach(i => diff(i) = i)
    equations.indices.foreach(i => {
      if (equations(i)(1) == '=') {
        val p = check(equations(i)(0) - 'a')
        val q = check(equations(i)(3) - 'a')
        if (p != q) diff(p) = q
      }
    })
    equations.indices.foreach(i => {
      if (equations(i)(1) == '!') {
        val p = check(equations(i)(0) - 'a')
        val q = check(equations(i)(3) - 'a')
        if (p == q) return false
      }
    })

    def check(_i: Int): Int = {
      var i = _i
      while (i != diff(i)) {
        diff(i) = diff(diff(i))
        i = diff(i)
      }
      i
    }

    true
  }
}
