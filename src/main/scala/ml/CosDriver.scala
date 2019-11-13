package ml

object CosDriver {

  //noinspection ScalaUnusedSymbol
  def main(args: Array[String]): Unit = {

    val user1FilmSource = Map("m1" -> 2, "m2" -> 3, "m3" -> 1, "m4" -> 0, "m5" -> 1)

    val user2FilmSource = Map("m1" -> 1, "m2" -> 2, "m3" -> 2, "m4" -> 1, "m5" -> 4)

    val user3FilmSource = Map("m1" -> 2, "m2" -> 1, "m3" -> 0, "m4" -> 1, "m5" -> 4)

    val user4FilmSource = Map("m1" -> 3, "m2" -> 2, "m3" -> 0, "m4" -> 5, "m5" -> 3)

    val user5FilmSource = Map("m1" -> 5, "m2" -> 3, "m3" -> 1, "m4" -> 1, "m5" -> 2)

    //--先计算user1和user2余弦距离的分子值
    val u1u2 = user1FilmSource zip user2FilmSource
    val u1u2Fenzi = u1u2.map { x => x._1._2 * x._2._2 }.sum
    val u1Fenmu = Math.sqrt(user1FilmSource.map { case (k, v) => v * v }.sum)
    val u2Fenmu = Math.sqrt(user2FilmSource.map { case (k, v) => v * v }.sum)
    val u1u2cos = u1u2Fenzi / (u1Fenmu * u2Fenmu)
    println(u1u2cos)
    println(cos(user1FilmSource, user3FilmSource))
    println(cos(user1FilmSource, user4FilmSource))
    println(cos(user1FilmSource, user5FilmSource))
  }

  //noinspection ScalaUnusedSymbol
  def cos(v1: Map[String, Int], v2: Map[String, Int]): Double = {
    val v1v2 = v1 zip v2
    val v1v2Fenzi = v1v2.map(x => x._1._2 * x._2._2).sum
    val v1Fenmu = Math.sqrt(v1.map { case (k, v) => v * v }.sum)
    val v2Fenmu = Math.sqrt(v2.map { case (k, v) => v * v }.sum)
    val v1v2cos = v1v2Fenzi / (v1Fenmu * v2Fenmu)
    v1v2cos
  }

}
