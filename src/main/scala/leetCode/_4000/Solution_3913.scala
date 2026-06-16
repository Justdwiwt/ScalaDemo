package leetCode._4000

object Solution_3913 {
  def sortVowels(s: String): String = {
    val vowels = Set('a', 'e', 'i', 'o', 'u')

    val it = s
      .zipWithIndex
      .filter(p => vowels(p._1))
      .groupBy(_._1)
      .toList
      .sortBy { case (_, xs) => (-xs.length, xs.head._2) }
      .iterator
      .flatMap { case (c, xs) => Iterator.fill(xs.length)(c) }

    s.map(c => if (vowels(c)) it.next() else c)
  }
}
