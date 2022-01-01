package leetCode

object Solution_906 {
  lazy val st: Set[BigInt] = (1 to 9)./:(Set.empty[BigInt])((a, b) => a + b) | (1 to 10000)./:(Set.empty[BigInt])((a, b) => {
    val l = b.toString
    val r = l.reverse
    val res = a + BigInt(l + r)
    (0 to 9)./:(res)((a, b) => a + BigInt(l + b + r))
  })

  def superpalindromesInRange(left: String, right: String): Int = {
    val l = BigInt(left)
    val r = BigInt(right)
    st./:(0)((a, b) => {
      val bSquare = b * b
      val f = bSquare.toString
      if (bSquare >= l && bSquare <= r && f == f.reverse) a + 1
      else a
    })
  }
}
