package leetCode._4000

object Solution_3921 {
  def scoreValidator(events: Array[String]): Array[Int] = {
    @scala.annotation.tailrec
    def loop(i: Int, score: Int, counter: Int): Array[Int] =
      if (i == events.length || counter == 10) Array(score, counter)
      else {
        val s = events(i)

        if (s.forall(_.isDigit)) {
          val n = s.toInt
          if (n <= 6) loop(i + 1, score + n, counter)
          else loop(i + 1, score, counter)
        } else s match {
          case "NB" | "WD" => loop(i + 1, score + 1, counter)
          case "W" => loop(i + 1, score, counter + 1)
          case _ => loop(i + 1, score, counter)
        }
      }

    loop(0, 0, 0)
  }
}
