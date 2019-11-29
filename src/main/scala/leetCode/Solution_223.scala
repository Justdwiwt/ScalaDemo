package leetCode

object Solution_223 {
  def computeArea(A: Int, B: Int, C: Int, D: Int, E: Int, F: Int, G: Int, H: Int): Int = {
    val left = A.max(E)
    val right = C.min(G).max(left)
    val bottom = B.max(F)
    val top = D.min(H).max(bottom)
    (C - A) * (D - B) - (right - left) * (top - bottom) + (G - E) * (H - F)
  }
}
