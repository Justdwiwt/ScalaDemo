package leetCode._2700

object Solution_2678 {
  def countSeniors(details: Array[String]): Int =
    details.count(_.slice(11, 13).toInt > 60)
}
