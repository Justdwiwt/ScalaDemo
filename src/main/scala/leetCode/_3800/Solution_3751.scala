package leetCode._3800

object Solution_3751 {
  def totalWaviness(num1: Int, num2: Int): Int = (num1 to num2)
    .filter(_ >= 100)
    .map(_.asDigits.sliding(3).count(k => {
      val List(a, b, c) = k
      (b < a && b < c) || (b > a && b > c)
    }))
    .sum

  implicit class Digits(num: Int) {
    def asDigits: List[Int] = loop(num, Nil)

    def loop(v: Int, list: List[Int]): List[Int] =
      if (v == 0) list
      else loop(v / 10, (v % 10) :: list)
  }
}
