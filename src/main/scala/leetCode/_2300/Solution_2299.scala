package leetCode._2300

object Solution_2299 {
  def strongPasswordCheckerII(password: String): Boolean = Some(password)
    .filter(_.length >= 8)
    .filter(_.exists(_.isUpper))
    .filter(_.exists(_.isLower))
    .filter(_.exists(_.isDigit))
    .filter(_.exists("!@#$%^&*()-+".toList.contains(_)))
    .exists(!_.toList.sliding(2).exists {
      case x :: xs :: _ => x == xs
      case _ => false
    })
}
