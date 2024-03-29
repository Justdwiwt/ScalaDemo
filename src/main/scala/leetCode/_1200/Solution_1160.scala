package leetCode._1200

object Solution_1160 {
  def countCharacters(words: Array[String], chars: String): Int = {
    def f(str: String, freq: Map[Char, Int]): Boolean = str
      .foldLeft(freq)((f, c) => f.updated(c, f.getOrElse(c, 0) - 1))
      .forall(_._2 >= 0)

    words.filter(f(_, chars.groupBy(identity).mapValues(_.length))).map(_.length).sum
  }
}
