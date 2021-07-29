package leetCode

object Solution_1946 {
  def maximumNumber(num: String, change: Array[Int]): String = {
    val arr = change.map(_.toString.head)
    num.zipWithIndex./:((num.toArray, 0))((acc, x) => {
      val zero = '0'.toInt
      val ch = arr(x._1.toInt - zero)
      if ((acc._2 == 0 && x._1 < ch) || (acc._2 == 1 && x._1 <= ch)) {
        acc._1(x._2) = ch
        (acc._1, 1)
      } else if (acc._2 > 0) (acc._1, 2)
      else acc
    })._1.mkString("")
  }
}
