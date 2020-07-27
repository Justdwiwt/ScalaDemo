package leetCode

import java.util

object Solution_1348 {

  class TweetCounts() {

    private val m = new util.HashMap[String, java.util.TreeMap[Int, Int]]()

    def recordTweet(tweetName: String, time: Int) {
      m.putIfAbsent(tweetName, new util.TreeMap[Int, Int]())
      val tm = m.get(tweetName)
      tm.put(time, tm.getOrDefault(time, 0) + 1)
    }

    def getTweetCountsPerFrequency(freq: String, tweetName: String, startTime: Int, endTime: Int): List[Int] = {
      var res = Array.empty[Int]
      if (!m.containsKey(tweetName)) return Nil
      val tm = m.get(tweetName)
      var gap = 60
      if (freq.equals("hour")) gap = 3600
      if (freq.equals("day")) gap = 3600 * 24
      (startTime to endTime by gap).foreach(i => {
        var sum = 0
        val end = (i + gap).min(endTime + 1)
        val t = tm.subMap(i, end)
        t.values().forEach(v => sum += v)
        res :+= sum
      })
      res.toList
    }

  }

}
