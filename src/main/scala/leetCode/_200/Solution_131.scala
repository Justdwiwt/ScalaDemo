package leetCode._200

object Solution_131 {
  def partition(s: String): List[List[String]] =
    if (s.isEmpty) List(List[String]())
    else s
      .zipWithIndex
      .map({ case (_, i) => s.slice(0, i + 1) })
      .filter(pre => pre == pre.reverse)
      .map(pre => partition(s.slice(pre.length, s.length)).map(rs => pre +: rs))
      .reduce((a, b) => a ++ b)
}
