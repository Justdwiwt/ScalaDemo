package leetCode._800

object Solution_793 {
  @scala.annotation.tailrec
  def preimageSizeFZF(K: Int): Int = K match {
    case k if k < 5 => 5
    case _ =>
      val p = Stream.iterate(1)(_ * 5 + 1).takeWhile(_ <= K).last
      if (K / p == 5) 0 else preimageSizeFZF(K % p)
  }
}
