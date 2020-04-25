package leetCode

object LCP_07 {
  def numWays(n: Int, relation: Array[Array[Int]], k: Int): Int = {
    var curr = Array(0)
    (0 until k).foreach(_ => {
      var next = Array.empty[Int]
      curr.indices.foreach(j => relation.indices.foreach(m => if (relation(m)(0) == curr(j)) next :+= relation(m)(1)))
      curr = next
    })
    curr.count(i => i == n - 1)
  }
}
