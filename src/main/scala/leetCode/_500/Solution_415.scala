package leetCode._500

object Solution_415 {
  def addStrings(num1: String, num2: String): String = {
    val (number, odd) = num1.reverse.zipAll(num2.reverse, '0', '0')./:[(String, Int)]("", 0)((res, e) => {
      val strToAdd = e._1.asDigit + e._2.asDigit + res._2
      (res._1 + strToAdd % 10, strToAdd / 10)
    })

    if (odd == 1) "1" + number.reverse else number.reverse
  }
}
