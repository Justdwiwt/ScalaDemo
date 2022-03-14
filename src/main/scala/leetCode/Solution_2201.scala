package leetCode

object Solution_2201 {
  def digArtifacts(n: Int, artifacts: Array[Array[Int]], dig: Array[Array[Int]]): Int = {
    val flag = Array.fill(n, n)(false)
    dig.foreach(d => flag(d.head)(d(1)) = true)
    var res = 0
    artifacts.foreach(a => if (f(flag, a.head, a(1), a(2), a(3))) res += 1)
    res
  }

  def f(flag: Array[Array[Boolean]], x1: Int, y1: Int, x2: Int, y2: Int): Boolean = {
    if (x2 == x1 + 1 && y2 == y1 + 1)
      flag(x1)(y1) && flag(x1)(y1 + 1) && flag(x1 + 1)(y1) && flag(x1 + 1)(y1 + 1)
    else if (x1 == x2) {
      (y1 to y2).foreach(i => if (!flag(x1)(i)) return false)
      true
    } else if (y1 == y2) {
      (x1 to x2).foreach(i => if (!flag(i)(y1)) return false)
      true
    } else flag(x1)(y1)
  }
}
