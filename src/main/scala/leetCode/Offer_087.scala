package leetCode

object Offer_087 {
  def restoreIpAddresses(s: String): List[String] =
    if (s == null || s.length > 12 || s.length < 4) Nil
    else ip.runP(s.toList).map(_._1)

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

  def pure[A](a: A): Parser[A] = Parser(l => List((a, l)))

  val item: Parser[Char] = Parser {
    case Nil => Nil
    case x :: xs => List((x, xs))
  }

  def sat(p: Char => Boolean): Parser[Char] =
    item.flatMap(x => if (p(x)) pure(x) else fail)

  val digit: Parser[Char] = sat(ch => '0' <= ch && ch <= '9')
  val zero: Parser[Char] = sat(ch => ch == '0')
  val nonZero: Parser[Char] = sat(ch => '1' <= ch && ch <= '9')

  def or[A](p1: Parser[A], p2: Parser[A]): Parser[A] =
    Parser(l => p1.runP(l) ++ p2.runP(l))

  def many1[A](p: Parser[A]): Parser[List[A]] =
    p.flatMap(x => many(p).map(xs => x :: xs))

  def many[A](p: Parser[A]): Parser[List[A]] = or(pure(Nil), many1(p))

  val numberStr: Parser[String] =
    or(zero.map(_.toString), nonZero.flatMap(d => many(digit).map(ds => (d :: ds).mkString)))

  val number: Parser[Int] = numberStr
    .map({ s => val v = scala.util.Try(s.toInt).getOrElse(Int.MaxValue); (s, v) })
    .flatMap({ case (_, v) => (if (v >= 256) fail else pure(v)).map(r => r) })

  val eof: Parser[Unit] = Parser {
    case Nil => List(((), Nil))
    case _ => Nil
  }

  val ip: Parser[String] = number
    .flatMap(n1 => number
      .flatMap(n2 => number
        .flatMap(n3 => number
          .flatMap(n4 => eof
            .map(_ => List(n1, n2, n3, n4).mkString("."))))))
}
