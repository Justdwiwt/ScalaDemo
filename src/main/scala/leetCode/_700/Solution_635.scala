package leetCode._700

import scala.collection.mutable

object Solution_635 {
  class LogSystem {

    private val hmTimestamps: mutable.SortedMap[Long, Int] = mutable.SortedMap.empty

    private val hmGranularity2Size = Map("Year" -> 0, "Month" -> 1, "Day" -> 2, "Hour" -> 3, "Minute" -> 4, "Second" -> 5)

    private def getDigits4Str(timestamp: String): mutable.Buffer[Long] =
      timestamp.split(":").map(_.toLong).toBuffer

    private def convertList2Long(st: mutable.Buffer[Long]): Long = {
      st(1) = st(1) - (if (st(1) == 0) 0 else 1)
      st(2) = st(2) - (if (st(2) == 0) 0 else 1)
      (st.head - 1999L) * (31 * 12) * 24 * 60 * 60 + st(1) * 31 * 24 * 60 * 60 + st(2) * 24 * 60 * 60 + st(3) * 60 * 60 + st(4) * 60 + st(5)
    }

    private def getGranularityEnds(timestamp: String, requiredGra: String, isEnd: Boolean): Long = {
      val res = mutable.Buffer.fill(6)(0L)
      val spt = getDigits4Str(timestamp)
      val gl = hmGranularity2Size(requiredGra)
      (0 to gl).foreach(i => res(i) = spt(i))
      if (isEnd) res(gl) += 1
      convertList2Long(res)
    }

    def put(id: Int, timestamp: String): Unit =
      hmTimestamps.put(convertList2Long(getDigits4Str(timestamp)), id)

    def retrieve(start: String, end: String, granularity: String): List[Int] = {
      val startKey = getGranularityEnds(start, granularity, isEnd = false)
      val endKey = getGranularityEnds(end, granularity, isEnd = true)
      hmTimestamps.range(startKey, endKey).values.toList
    }
  }
}
