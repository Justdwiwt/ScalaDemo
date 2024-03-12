package leetCode.offer

object Offer_108 {
  def ladderLength(beginWord: String, endWord: String, wordList: List[String]): Int = {
    var q = scala.collection.immutable.Queue[String](beginWord)
    var m = Map[String, Int](wordList.toStream.map((_, Integer.MAX_VALUE)): _*) + (beginWord -> 1)
    while (q.nonEmpty) {
      val curWord = q.dequeue._1
      val curDist = m.getOrElse(curWord, Integer.MAX_VALUE)
      q = q.dequeue._2
      if (curWord == endWord) return m(endWord)
      val ch = curWord.toCharArray
      ('a' to 'z').foreach(t => {
        ch.indices.foreach(i => {
          val old = ch(i)
          ch(i) = t
          val nextNode = ch./:("")(_ + _)
          m.get(nextNode).foreach(d => {
            if (d > curDist + 1) {
              m = m + (nextNode -> (curDist + 1))
              q = q.enqueue(nextNode)
            }
          })
          ch(i) = old
        })
      })
    }
    0
  }
}
