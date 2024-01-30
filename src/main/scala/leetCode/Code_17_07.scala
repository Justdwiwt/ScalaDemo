package leetCode

import scala.collection.mutable

object Code_17_07 {
  def trulyMostPopular(names: Array[String], synonyms: Array[String]): Array[String] = {
    val m = names.map(str => {
      val nameFreq = str.substring(0, str.length - 1).split("\\(")
      (nameFreq.head, nameFreq(1).toInt)
    })

    val unionSet = new UnionSet(m)
    synonyms.foreach(str => {
      val names = str.substring(1, str.length - 1).split(",")
      unionSet.union(names.head, names(1))
    })

    unionSet.getAllFreq
  }

  private class UnionSet(map: Array[(String, Int)]) {
    private val parent = mutable.HashMap.empty[String, String]
    private val freq = mutable.HashMap.empty[String, Int] ++= map

    private def find(x: String): String = {
      if (x != parent.getOrElse(x, x)) parent(x) = find(parent(x))
      parent.getOrElse(x, x)
    }

    def union(x: String, y: String): Unit = {
      val rootX = find(x)
      val rootY = find(y)
      if (rootX == rootY) return
      val small = if (rootX > rootY) rootY else rootX
      val big = if (rootX > rootY) rootX else rootY
      parent(big) = small
      freq += small -> (freq.getOrElse(small, 0) + freq.getOrElse(big, 0))
      freq -= big
    }

    def getAllFreq: Array[String] = freq
      .map(e => e._1 + "(" + e._2 + ")")
      .toArray
  }
}
