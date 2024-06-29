package leetCode._1300

import scala.collection.mutable
import scala.collection.mutable.ArrayBuffer

object Solution_1258 {
  def generateSentences(synonyms: List[List[String]], text: String): List[String] = {
    val words = text.split(" ")

    var idx = 0
    val idxMap = mutable.Map[String, Int]()
    synonyms.foreach(_.foreach(s => {
      if (!idxMap.contains(s)) {
        idxMap(s) = idx
        idx += 1
      }
    }))

    val unionFind = new UnionFind(idx)
    synonyms.foreach(synonym => {
      val syn0 = synonym.head
      val syn1 = synonym(1)
      unionFind.union(idxMap(syn0), idxMap(syn1))
    })

    val resList = ArrayBuffer[String]()
    dfs(unionFind, resList, idxMap, words, 0)
    resList.sorted.toList
  }

  private def dfs(
                   unionFind: UnionFind,
                   resList: ArrayBuffer[String],
                   idxMap: mutable.Map[String, Int],
                   words: Array[String],
                   curI: Int
                 ): Unit = {
    if (curI == words.length) resList += words.mkString(" ")
    else if (idxMap.contains(words(curI))) {
      val oldWord = words(curI)
      idxMap.foreach { case (newWord, idx) =>
        if (unionFind.connected(idx, idxMap(oldWord))) {
          words(curI) = newWord
          dfs(unionFind, resList, idxMap, words.clone(), curI + 1)
          words(curI) = oldWord
        }
      }
    }
    else dfs(unionFind, resList, idxMap, words.clone(), curI + 1)
  }

  private class UnionFind(n: Int) {
    private val parent: Array[Int] = (0 until n).toArray
    private val rank: Array[Int] = Array.fill(n)(0)
    private var count: Int = n

    private def find(x: Int): Int = {
      var ret = x
      while (ret != parent(ret)) {
        parent(ret) = parent(parent(ret))
        ret = parent(ret)
      }
      ret
    }

    def union(p: Int, q: Int): Unit = {
      val rootP = find(p)
      val rootQ = find(q)
      if (rootP != rootQ) {
        if (rank(rootP) > rank(rootQ)) parent(rootQ) = rootP
        else if (rank(rootP) < rank(rootQ)) parent(rootP) = rootQ
        else {
          parent(rootQ) = rootP
          rank(rootP) += 1
        }
        count -= 1
      }
    }

    def connected(p: Int, q: Int): Boolean =
      find(p) == find(q)
  }
}
