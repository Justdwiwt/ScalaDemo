package leetCode._800

object Solution_793 {
  @scala.annotation.tailrec
  def preimageSizeFZF(K: Int): Int = {
    if (K < 5) return 5
    var p = 1
    while (p * 5 + 1 <= K) p = p * 5 + 1
    if (K / p == 5) return 0
    preimageSizeFZF(K % p)
  }
}
