package leetCode._900

object Solution_838 {
  def pushDominoes(dominoes: String): String = Iterator(
    "^\\.+(?=L)" -> ("L" * (_: Int)),
    "(?<=L)\\.+(?=L)" -> ("L" * (_: Int)),
    "(?<=R)\\.+$" -> ("R" * (_: Int)),
    "(?<=R)\\.+(?=R)" -> ("R" * (_: Int)),
    "(?<=R)\\.+(?=L)" -> ((n: Int) => ("R" * (n / 2)) + ("." * (n % 2)) + ("L" * (n / 2))))
    .foldLeft(dominoes) { case (dominoes, (regex, f)) => regex.r.replaceAllIn(dominoes, m => f(m.matched.length)) }
}
