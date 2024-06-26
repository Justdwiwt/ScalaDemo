package leetCode._500

object Solution_423 {
  private val ZERO = Array(0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 1)

  private val ONE = Array(0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0)

  private val TWO = Array(0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 1, 0, 0, 1, 0, 0, 0)

  private val THREE = Array(0, 0, 0, 0, 2, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 1, 0, 0, 0, 0, 0, 0)

  private val FOUR = Array(0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 1, 0, 0, 1, 0, 0, 0, 0, 0)

  private val FIVE = Array(0, 0, 0, 0, 1, 1, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0)

  private val SIX = Array(0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 1, 0, 0)

  private val SEVEN = Array(0, 0, 0, 0, 2, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 1, 0, 0, 1, 0, 0, 0, 0)

  private val EIGHT = Array(0, 0, 0, 0, 1, 0, 1, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0)

  private val NINE = Array(0, 0, 0, 0, 1, 0, 0, 0, 1, 0, 0, 0, 0, 2, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0)

  private trait Extractor {
    def coding: Array[Int]

    private def minus(chars: Array[Int], times: Int): Unit =
      (0 until times).foreach(_ => (0 until 26).foreach(i => chars(i) -= coding(i)))

    def tagExtract(chars: Array[Int], loc: Int, which: Int): String =
      if (chars(loc) > 0) {
        val tmp = chars(loc)
        minus(chars, chars(loc))
        Array.tabulate(tmp)(_ => which.toString).mkString("")
      } else ""

    def extract(chars: Array[Int]): String
  }

  private case class ZeroExtractor(coding: Array[Int] = ZERO) extends Extractor {
    override def extract(chars: Array[Int]): String = tagExtract(chars, 25, 0)
  }

  private case class TwoExtractor(coding: Array[Int] = TWO) extends Extractor {
    override def extract(chars: Array[Int]): String = tagExtract(chars, 22, 2)
  }

  private case class FourExtractor(coding: Array[Int] = FOUR) extends Extractor {
    override def extract(chars: Array[Int]): String = tagExtract(chars, 20, 4)
  }

  private case class FiveExtractor(coding: Array[Int] = FIVE) extends Extractor {
    override def extract(chars: Array[Int]): String = tagExtract(chars, 5, 5)
  }

  private case class SixExtractor(coding: Array[Int] = SIX) extends Extractor {
    override def extract(chars: Array[Int]): String = tagExtract(chars, 23, 6)
  }

  private case class SevenExtractor(coding: Array[Int] = SEVEN) extends Extractor {
    override def extract(chars: Array[Int]): String = tagExtract(chars, 21, 7)
  }

  private case class EightExtractor(coding: Array[Int] = EIGHT) extends Extractor {
    override def extract(chars: Array[Int]): String = tagExtract(chars, 6, 8)
  }

  private case class OneExtractor(coding: Array[Int] = ONE) extends Extractor {
    override def extract(chars: Array[Int]): String = tagExtract(chars, 14, 1)
  }

  private case class ThreeExtractor(coding: Array[Int] = THREE) extends Extractor {
    override def extract(chars: Array[Int]): String = tagExtract(chars, 17, 3)
  }

  private case class NineExtractor(coding: Array[Int] = NINE) extends Extractor {
    override def extract(chars: Array[Int]): String = tagExtract(chars, 8, 9)
  }

  def originalDigits(s: String): String = {
    val chars = new Array[Int](26)
    s.foreach(c => chars(c - 'a') += 1)
    val sb = new StringBuilder
    sb.append(ZeroExtractor().extract(chars))
    sb.append(TwoExtractor().extract(chars))
    sb.append(FourExtractor().extract(chars))
    sb.append(FiveExtractor().extract(chars))
    sb.append(SixExtractor().extract(chars))
    sb.append(SevenExtractor().extract(chars))
    sb.append(EightExtractor().extract(chars))
    sb.append(OneExtractor().extract(chars))
    sb.append(ThreeExtractor().extract(chars))
    sb.append(NineExtractor().extract(chars))
    sb.toString().sorted
  }
}
