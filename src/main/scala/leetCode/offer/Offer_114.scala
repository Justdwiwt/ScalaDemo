package leetCode.offer

import scala.collection.mutable

object Offer_114 {
  def alienOrder(words: Array[String]): String = {
    val graph = Array.fill(26, 26)(false)
    val inDegree = Array.fill(26)(0)
    val exist = Array.fill(26)(false)
    words.indices.foreach(i => words(i).toCharArray.foreach(c => exist(c - 'a') = true))
    words.indices.dropRight(1).foreach(i => {
      val j = i + 1
      val w1 = words(i).toCharArray
      val w2 = words(j).toCharArray
      var cur1, cur2 = 0
      while (cur1 < w1.length && cur2 < w2.length && w1(cur1) == w2(cur2)) {
        cur1 += 1
        cur2 += 1
      }
      if (cur1 < w1.length && cur2 == w2.length) return ""
      if (cur1 < w1.length && cur2 < w2.length) {
        val from = w1(cur1)
        val to = w2(cur2)
        inDegree(to - 'a') += (if (graph(from - 'a')(to - 'a')) 0 else 1)
        graph(from - 'a')(to - 'a') = true
      }
    })
    val order = toPoSort(graph, inDegree, exist)
    order.mkString
  }

  def toPoSort(graph: Array[Array[Boolean]], inDegree: Array[Int], exist: Array[Boolean]): Array[Char] = {
    var order = Array.emptyCharArray
    val q = mutable.Queue.empty[Int]
    var cnt = 0
    (0 until 26).foreach(i => {
      if (exist(i) && inDegree(i) == 0) q += i
      if (exist(i)) cnt += 1
    })
    while (q.nonEmpty) {
      val i = q.dequeue()
      order :+= (i + 'a').toChar
      (0 until 26).foreach(j => if (graph(i)(j)) {
        graph(i)(j) = false
        inDegree(j) -= 1
        if (inDegree(j) == 0) q += j
      })
    }
    if (order.length == cnt) order
    else Array.emptyCharArray
  }
}
