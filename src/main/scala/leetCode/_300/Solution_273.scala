package leetCode._300

object Solution_273 {
  private val under20 = Seq("Zero", "One", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine", "Ten", "Eleven", "Twelve", "Thirteen", "Fourteen", "Fifteen", "Sixteen", "Seventeen", "Eighteen", "Nineteen")
  val tens: Seq[String] = Seq("", "", "Twenty", "Thirty", "Forty", "Fifty", "Sixty", "Seventy", "Eighty", "Ninety")
  private val tousands = Seq("", " Thousand", " Million", " Billion")

  private def underK(num: Int): String = num match {
    case n if n < 20 => under20(n)
    case n if n < 100 => tens(n / 10) + " " + recNumber(n % 10, 0)
    case n => recNumber(n / 100, 0) + " Hundred " + recNumber(n % 100, 0)
  }

  private def recNumber(num: Int, tidx: Int): String = num match {
    case n if n == 0 => ""
    case n if n < 1000 => underK(n) + tousands(tidx)
    case _ => recNumber(num / 1000, tidx + 1) + " " + recNumber(num % 1000, tidx)
  }

  def numberToWords(num: Int): String =
    if (num == 0) under20.head else recNumber(num, 0).trim.replaceAll(" +", " ")
}
