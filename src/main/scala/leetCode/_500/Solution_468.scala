package leetCode._500

object Solution_468 {

  def validIPAddress(IP: String): String = parser.runP(IP.toList.map(_.toLower)).find(_._2.isEmpty) match {
    case None => "Neither"
    case Some(x) => x._1 match {
      case IPV4(_) => "IPv4"
      case IPV6(_) => "IPv6"
    }
  }

  abstract class IP

  case class IPV4(v: String) extends IP

  private case class IPV6(v: String) extends IP

  case class Parser[+A](runP: List[Char] => List[(A, List[Char])]) {
    def map[B](f: A => B): Parser[B] = Parser(runP(_) match {
      case Nil => Nil
      case xs => xs.map(x => (f(x._1), x._2))
    })

    def flatMap[B](f: A => Parser[B]): Parser[B] = Parser(runP(_) match {
      case Nil => Nil
      case xs => xs.flatMap(x => f(x._1).runP(x._2))
    })
  }

  val fail: Parser[Nothing] = Parser(_ => Nil)

  private def success[A](a: A): Parser[A] = Parser(l => List((a, l)))

  val item: Parser[Char] = Parser {
    case Nil => Nil
    case x :: xs => List((x, xs))
  }

  private def isDigit(ch: Char): Boolean = ch >= '0' && ch <= '9'

  private def isNoneZeroDigit(ch: Char): Boolean = ch >= '1' && ch <= '9'

  private def isHex(ch: Char): Boolean = isDigit(ch) || ('a' <= ch && ch <= 'f')

  private def sat(p: Char => Boolean): Parser[Char] = item.flatMap(x => if (p(x)) success(x) else fail)

  private def char(x: Char): Parser[Char] = sat(_ == x)

  private def digit: Parser[Char] = sat(isDigit)

  private def nonZero: Parser[Char] = sat(isNoneZeroDigit)

  private def hex: Parser[Char] = sat(isHex)

  private def or[A](p: Parser[A], q: Parser[A]): Parser[A] = Parser(l => p.runP(l) ++ q.runP(l))

  private def repeat[A](p: Parser[A], n: Int): Parser[List[A]] =
    if (n == 1) p.map(List(_))
    else p.flatMap(x => repeat(p, n - 1).map(x :: _))

  private def atMost[A](p: Parser[A], n: Int, l: Int): Parser[List[A]] =
    if (n > l) or(repeat(p, n), atMost(p, n - 1, l))
    else if (n == 0) success(Nil)
    else repeat(p, l)

  private def zero: Parser[IPV4] = char('0').map(_ => IPV4("0"))

  private def nonZeroIpv4: Parser[IPV4] = nonZero
    .flatMap(x => atMost(digit, 2, 0)
      .map { xs => val str = (x :: xs).mkString; (xs, str) }
      .map { case (xs, str) => val value = str.toInt; (xs, str, value) }
      .flatMap { case (_, str, value) => (if (value >= 256) fail else success(str)).map(IPV4) }
    )

  private def ipv4Num: Parser[IPV4] = or(zero, nonZeroIpv4)

  private def ipv6Num: Parser[IPV6] = atMost(hex, 4, 1).map(x => IPV6(x.mkString))

  val dot: Parser[(IPV4, IPV4) => IPV4] = char('.').map(_ => (s1: IPV4, s2: IPV4) => IPV4(s1.v.concat(".").concat(s2.v)))

  private val colon: Parser[(IPV6, IPV6) => IPV6] = char(':').map(_ => {
    case (s1: IPV6, s2: IPV6) => IPV6(s1.v.concat(":").concat(s2.v))
  })

  private def chain[A](p: Parser[A], ops: Parser[(A, A) => A], n: Int): Parser[A] = p
    .flatMap(x => repeat(ops.flatMap(f => p.map((f, _))), n)
      .map(_./:(x) { case (acc, (g, i)) => g(acc, i) }))

  private val ipv4: Parser[IPV4] = chain(ipv4Num, dot, 3)
  private val ipv6: Parser[IPV6] = chain(ipv6Num, colon, 7)
  private val parser: Parser[IP] = or(ipv4, ipv6)

}
