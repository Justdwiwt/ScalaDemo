package leetCode

object Solution_816 {
  @scala.annotation.tailrec
  def ambiguousCoordinates(s: String): List[String] = {
    def f(s: String): List[String] = List(s)
      .filter(x => x == "0" || !x.startsWith("0")) ::: s
      .indices
      .drop(1)
      .toList
      .map(k => s.take(k) + "." + s.drop(k))
      .filterNot(x => x.startsWith("00") || (x.startsWith("0") && !x.startsWith("0.")) || x.endsWith("0"))

    if (s.startsWith("(")) ambiguousCoordinates(s.init.tail)
    else s
      .indices
      .drop(1)
      .toList
      .flatMap(i => f(s.take(i)).flatMap(a => f(s.drop(i)).map(b => "(" + a + ", " + b + ")")))
  }
}
