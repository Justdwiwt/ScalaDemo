package leetCode._100

object Solution_68 {
  def fullJustify(words: Array[String], maxWidth: Int): List[String] =
    format(words.toList./:(List[String]()) { case (acc, s) => acc ++ s.trim.split("\\s+").toList }, maxWidth, Nil, Nil)

  @scala.annotation.tailrec
  def format(words: List[String], limit: Int, acc: List[String], tmp: List[String]): List[String] = words match {
    case Nil if tmp.isEmpty => acc
    case Nil =>
      val tmpStr = tmp.mkString(" ")
      acc :+ (tmpStr :+ fillSpace(limit - tmpStr.length)).mkString
    case w :: tailWords if tmp.map(_.length).sum + tmp.length + w.length <= limit => format(tailWords, limit, acc, tmp :+ w)
    case w :: tailWords => format(tailWords, limit, acc :+ justify(limit, tmp).mkString, List(w))
  }

  def justify(limit: Int, tmp: List[String]): List[String] = {
    val spacesAvail = limit - tmp.map(_.length).sum
    if (tmp.length <= 1) tmp :+ fillSpace(spacesAvail)
    else {
      val gaps = tmp.length - 1
      val baseGap = spacesAvail / gaps
      val remainders = spacesAvail % gaps
      justify(limit, tmp, Nil, baseGap, remainders)
    }
  }

  @scala.annotation.tailrec
  def justify(limit: Int, tmp: List[String], acc: List[String], baseGap: Int, remainders: Int): List[String] = tmp match {
    case Nil => throw new Exception("never happen")
    case word :: Nil => acc :+ word
    case word :: tail =>
      val spaces = baseGap + (if (remainders > 0) 1 else 0)
      justify(limit, tail, acc :+ word :+ fillSpace(spaces), baseGap, if (remainders > 0) remainders - 1 else 0)
  }

  def fillSpace(n: Int): String = List.fill(n)(" ").mkString
}
