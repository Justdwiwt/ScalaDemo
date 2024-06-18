package leetCode._2300

object Solution_2288 {
  def discountPrices(s: String, discount: Int): String = s
    .split(' ')
    .map(word => {
      if (word.head == '$' && word.length > 1) {
        val rest = word.substring(1)
        if (rest.forall(_.isDigit)) {
          val nv = rest.toDouble - (rest.toDouble * (discount.toDouble / 100.0))
          "$" ++ "%1.2f".format(nv)
        }
        else word
      }
      else word
    })
    .mkString(" ")
}
