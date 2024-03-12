package leetCode._2400

object Solution_2361 {
  def minimumCosts(regular: Array[Int], express: Array[Int], expressCost: Int): Array[Long] = {
    val n = regular.length
    val res = Array.fill(n)(0L)
    var inRegular = 0L
    var inExpress = expressCost.toLong
    regular.indices.foreach(i => {
      val nextInRegular = (inRegular + regular(i)).min(inExpress + regular(i))
      val nextInExpress = (inRegular + expressCost + express(i)).min(inExpress + express(i))
      res(i) = nextInExpress.min(nextInRegular)
      inRegular = nextInRegular
      inExpress = nextInExpress
    })
    res
  }
}
