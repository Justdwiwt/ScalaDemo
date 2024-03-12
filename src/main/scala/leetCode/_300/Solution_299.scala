package leetCode._300

object Solution_299 {
  def getHint(secret: String, guess: String): String = {
    lazy val a = secret.zip(guess).count { case (s, g) => s == g }
    lazy val List(s, g) = List(secret, guess).map(_.groupBy(identity).mapValues(_.length).toMap)
    lazy val b = s.map { case (k, v) => g.getOrElse(k, 0).min(v) }.sum - a
    a.toString + "A" + b + "B"
  }
}
