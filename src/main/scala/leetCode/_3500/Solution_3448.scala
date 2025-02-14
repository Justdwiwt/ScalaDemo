package leetCode._3500

object Solution_3448 {
  def countSubstrings(s: String): Long = {
    val initialF = Array.fill(10, 9)(0)
    s.foldLeft((initialF, 0L)) { case ((f, res), dChar) =>
      val d = dChar.asDigit
      val updatedF = (1 to 9).foldLeft(f)((accF, m) => {
        val nf = Array.fill(m)(0)
        nf(d % m) = 1
        (0 until m).foreach(rem => nf((rem * 10 + d) % m) += accF(m)(rem))
        accF.updated(m, nf)
      })
      val newAns = res + updatedF(d)(0)
      (updatedF, newAns)
    }._2
  }
}
