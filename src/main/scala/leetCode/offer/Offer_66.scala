package leetCode.offer

object Offer_66 {
  def constructArr(a: Array[Int]): Array[Int] = {
    val diffL = Array.fill(a.length)(1)
    val diffR = Array.fill(a.length)(1)
    (1 until a.length).foreach(i => diffL(i) = diffL(i - 1) * a(i - 1))
    (a.length - 2 until -1 by (-1)).foreach(i => diffR(i) = diffR(i + 1) * a(i + 1))
    a.indices.foreach(i => diffL(i) = diffL(i) * diffR(i))
    diffL
  }
}
