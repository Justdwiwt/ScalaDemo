package leetCode._3700

object Solution_3606 {
  private val order = Seq("electronics", "grocery", "pharmacy", "restaurant")
  private val orderIn = order.zipWithIndex.toMap
  private val codePat = "^[A-Za-z0-9_]+$".r

  def validateCoupons(code: Array[String], businessLine: Array[String], isActive: Array[Boolean]): List[String] = code
    .zip(businessLine)
    .zip(isActive)
    .collect { case ((c, bl), true)
      if c.nonEmpty && codePat.pattern.matcher(c).matches() && orderIn.contains(bl) => (bl, c)
    }
    .sortBy { case (bl, c) => (orderIn(bl), c) }
    .map(_._2)
    .toList
}
