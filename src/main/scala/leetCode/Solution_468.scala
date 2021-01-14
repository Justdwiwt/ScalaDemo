package leetCode

object Solution_468 {

  def validIPAddress(IP: String): String = parser.runP(IP.toList.map(_.toLower)).find(x => x._2.isEmpty) match {
    case None => "Neither"
    case Some(x) => x._1 match {
      case IPV4(_) => "IPv4"
      case IPV6(_) => "IPv6"
    }
  }

  abstract class IP

  case class IPV4(v: String) extends IP

  case class IPV6(v: String) extends IP

  case class Parser[+A](runP: List[Char] => List[(A, List[Char])]) {
    def map[B](f: A => B): Parser[B] = Parser(l => runP(l) match {
      case Nil => Nil
      case xs => xs.map(x => (f(x._1), x._2))
    })

    def flatMap[B](f: A => Parser[B]): Parser[B] = Parser(l => runP(l) match {
      case Nil => Nil
      case xs => xs.flatMap(x => f(x._1).runP(x._2))
    })
  }

  val fail: Parser[Nothing] = Parser(_ => Nil)

  def success[A](a: A): Parser[A] = Parser(l => List((a, l)))

  val item: Parser[Char] = Parser {
    case Nil => Nil
    case x :: xs => List((x, xs))
  }

  def isDigit(ch: Char): Boolean = ch >= '0' && ch <= '9'

  def isNoneZeroDigit(ch: Char): Boolean = ch >= '1' && ch <= '9'

  def isHex(ch: Char): Boolean = isDigit(ch) || ('a' <= ch && ch <= 'f')

  def sat(p: Char => Boolean): Parser[Char] = item.flatMap(x => if (p(x)) success(x) else fail)

  def char(x: Char): Parser[Char] = sat(ch => ch == x)

  def digit: Parser[Char] = sat(isDigit)

  def nonZero: Parser[Char] = sat(isNoneZeroDigit)

  def hex: Parser[Char] = sat(isHex)

  def or[A](p: Parser[A], q: Parser[A]): Parser[A] = Parser(l => p.runP(l) ++ q.runP(l))

  def repeat[A](p: Parser[A], n: Int): Parser[List[A]] =
    if (n == 1) p.map(List(_))
    else p.flatMap(x => repeat(p, n - 1).map(xs => x :: xs))

  def atMost[A](p: Parser[A], n: Int, l: Int): Parser[List[A]] =
    if (n > l) or(repeat(p, n), atMost(p, n - 1, l))
    else if (n == 0) success(Nil)
    else repeat(p, l)

  def zero: Parser[IPV4] = char('0').map(_ => IPV4("0"))

  def nonZeroIpv4: Parser[IPV4] =
    nonZero.flatMap(x => atMost(digit, 2, 0)
      .map({ xs => val str = (x :: xs).mkString; (xs, str) })
      .map({ case (xs, str) => val value = str.toInt; (xs, str, value) })
      .flatMap({ case (_, str, value) => (if (value >= 256) fail else success(str)).map(s => IPV4(s)) })
    )

  def ipv4Num: Parser[IPV4] = or(zero, nonZeroIpv4)

  def ipv6Num: Parser[IPV6] = atMost(hex, 4, 1).map(x => IPV6(x.mkString))

  val dot: Parser[(IPV4, IPV4) => IPV4] = char('.').map(_ => (s1: IPV4, s2: IPV4) => IPV4(s1.v.concat(".").concat(s2.v)))

  val colon: Parser[(IPV6, IPV6) => IPV6] = char(':').map(_ => {
    case (s1: IPV6, s2: IPV6) => IPV6(s1.v.concat(":").concat(s2.v))
  })

  def chain[A](p: Parser[A], ops: Parser[(A, A) => A], n: Int): Parser[A] =
    p.flatMap(x => repeat(ops.flatMap(f => p.map(y => (f, y))), n)
      .map(fys => fys./:(x) { case (acc, (g, i)) => g(acc, i) }))

  val ipv4: Parser[IPV4] = chain(ipv4Num, dot, 3)
  val ipv6: Parser[IPV6] = chain(ipv6Num, colon, 7)
  val parser: Parser[IP] = or(ipv4, ipv6)

}
