package leetCode._1400

object Solution_1309 {
  def freqAlphabets(s: String): String = ('a' to 'z')
    .zipWithIndex
    .view
    .reverse
    ./:(s) { case (s, (c, i)) =>
      val rep = (i + 1) + (if (i < 9) "" else "#")
      s.replaceAll(rep, "" + c)
    }
}
