package leetCode

object Solution_2129 {
  def capitalizeTitle(title: String): String = {
    val t = title.split(" ")
    val res = new StringBuilder(f(t.head))
    t.indices.drop(1).foreach(i => res.append(" ").append(f(t(i))))
    res.toString()
  }

  def f(s: String): String =
    if (s.length > 2) new StringBuilder(s.substring(0, 1).toUpperCase()).append(s.substring(1).toLowerCase()).toString()
    else s.toLowerCase()
}
