package leetCode

object Offer_086 {
  def partition(s: String): Array[Array[String]] =
    if (s.isEmpty) Array(Array[String]())
    else s
      .zipWithIndex
      .map({ case (_, i) => s.slice(0, i + 1) })
      .filter(pre => pre == pre.reverse)
      .map(pre => partition(s.slice(pre.length, s.length)).map(rs => pre +: rs))
      .reduce((a, b) => a ++ b)
}
