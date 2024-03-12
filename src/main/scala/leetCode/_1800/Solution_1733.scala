package leetCode._1800

object Solution_1733 {
  def minimumTeachings(n: Int, languages: Array[Array[Int]], friendships: Array[Array[Int]]): Int = {
    val lang = languages.map(_.toSet)
    languages
      .flatten
      .distinct
      .map(l => friendships
        .filterNot({ case Array(a, b) => languages(a - 1).exists(lang(b - 1).contains) })
        .flatten
        .distinct
        .filterNot(x => lang(x - 1).contains(l))
        .length)
      .min
  }
}
