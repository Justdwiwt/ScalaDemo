package leetCode

object Solution_336 {

  type SDT = (List[Option[Word]], Option[Word], Int)
  type ZDT = (Array[Int], Int, Int)

  case class Word(v: Char, n: Option[Word])

  def palindromePairs(words: Array[String]): List[List[Int]] = {
    val dictR = dict(words)
    val dictL = dict(words.map(_.reverse))

    words
      .zipWithIndex
      .flatMap({ case (_, i) => getPairs(dictR, words(i).reverse).map(List(_, i)) ++ getPairs(dictL, words(i)).map(List(i, _)) })
      .filter(p => p.head != p(1))
      .distinct
      .toList
  }

  def convertWord(s: String): Option[Word] = s.toList./:(Option.empty[Word])((prev: Option[Word], c: Char) => Some(Word(c, prev)))

  def dict(words: Array[String]): Map[Option[Word], Int] = words.map(convertWord).zipWithIndex.toMap

  def getPairs(dict: Map[Option[Word], Int], s: String): List[Int] = getPolindroms(s)
    .:\((List.empty[Option[Word]], convertWord(s), s.length - 1))(getPrefixes)
    ._1
    .flatMap(dict.get)

  @scala.annotation.tailrec
  def getPrefixes(idx: Int, d: SDT): SDT =
    if (d._3 < idx) (d._1 :+ d._2, d._2, d._3)
    else getPrefixes(idx, (d._1, d._2.get.n, d._3 - 1))

  def getPolindroms(s: String): Array[Int] = {
    val n = s.length * 2 + 1
    (1 until n)
      ./:(Array(n), 0, 0)(getZElem(s.reverse + "\u0000" + s))
      ._1
      .zipWithIndex
      .filter(d => d._2 > n / 2 && n - d._2 - d._1 < 2)
      .map(_._2 - n / 2 - 1) :+ n / 2
  }

  def getZElem(s: String)(d: ZDT, i: Int): ZDT = d match {
    case (res, l, r) if i > r =>
      val rN = getR(s, i, i)
      (res :+ (rN - l), i, rN)
    case (res, l, r) if res(i - l) > r - i =>
      val rN = getR(s, i, r)
      (res :+ (rN - l), i, rN)
    case (res, l, r) => (res :+ res(i - l), l, r)
  }

  @scala.annotation.tailrec
  def getR(s: String, L: Int, R: Int): Int = if (R == s.length || s(R - L) != s(R)) R - 1 else getR(s, L, R + 1)

}
