package leetCode.crackingCodeInterview

import scala.collection.mutable
import scala.collection.mutable.ListBuffer

object Code_17_26 {
  def computeSimilarities(docs: Array[Array[Int]]): List[String] = {
    val res = ListBuffer.empty[String]
    val m = mutable.HashMap.empty[Int, ListBuffer[Int]]
    val arr = Array.fill(docs.length)(Array.fill(docs.length)(0))
    docs.indices.foreach(i => {
      docs(i).indices.foreach(j => {
        val t = m.getOrElseUpdate(docs(i)(j), ListBuffer.empty[Int])
        t.foreach(k => arr(i)(k) += 1)
        t += i
      })

      docs.indices.foreach(k => if (arr(i)(k) > 0) {
        val t = arr(i)(k).toDouble / (docs(i).length + docs(k).length - arr(i)(k))
        res += (k.toString ++ "," ++ i.toString ++ ": " ++ t.formatted("%.4f"))
      })
    })
    res.toList
  }
}
