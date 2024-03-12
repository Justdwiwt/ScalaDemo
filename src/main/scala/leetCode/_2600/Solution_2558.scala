package leetCode._2600

object Solution_2558 {
  def pickGifts(gifts: Array[Int], k: Int): Long = {
    val zip = gifts.zipWithIndex
    (1 to k).foreach(_ => {
      val (next, i) = zip.maxBy(_._1)
      zip(i) = (math.sqrt(next).toInt, i)
    })
    zip.map(_._1).map(_.toLong).sum
  }
}
