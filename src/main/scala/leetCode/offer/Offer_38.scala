package leetCode.offer

object Offer_38 {
  def permutation(s: String): Array[String] = {
    val ch = s.toCharArray
    var arr = Array.empty[String]
    ch.permutations.foreach(arr :+= _.mkString)
    arr
  }
}
