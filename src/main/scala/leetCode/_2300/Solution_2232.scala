package leetCode._2300

object Solution_2232 {
  def minimizeResult(e: String): String = {
    val plus = e.indexOf('+')
    val num1 = e.take(plus).toInt
    val num2 = e.drop(plus + 1).toInt

    def int(s: String) =
      if (s.isEmpty) 1
      else s.toInt

    var res = (0, e.length - 1, num1 + num2)

    (0 until plus).foreach(i => (plus + 1 until e.length).foreach(j => {
      val temp = int(e.take(i)) * (int(e.slice(i, plus)) + int(e.slice(plus + 1, j + 1))) * int(e.drop(j + 1))
      if (temp < res._3) res = (i, j, temp)
    }))

    e.take(res._1) + "(" + e.slice(res._1, res._2 + 1) + ")" + e.drop(res._2 + 1)
  }
}
