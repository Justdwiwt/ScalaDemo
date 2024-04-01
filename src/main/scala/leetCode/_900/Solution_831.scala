package leetCode._900

object Solution_831 {
  def maskPII(s: String): String =
    if (s.contains('@')) maskEmail(s)
    else maskPhone(s)

  private def maskPhone(s: String): String = {
    val p = s.filter(_.isDigit)
    val last = p.takeRight(4)
    p.length match {
      case 10 => "***-***-" + last
      case 11 => "+*-***-***-" + last
      case 12 => "+**-***-***-" + last
      case _ => "+***-***-***-" + last
    }
  }

  private def maskEmail(s: String): String = {
    val Array(name, domain) = s.toLowerCase().split('@')
    s"${name(0)}*****${name.last}@$domain"
  }
}
