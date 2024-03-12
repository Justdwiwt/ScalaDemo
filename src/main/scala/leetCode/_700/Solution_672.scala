package leetCode._700

object Solution_672 {
  def flipLights(n: Int, m: Int): Int = {
    val t = n.min(3)
    (1 << t).min(1 + m * t)
  }
}
