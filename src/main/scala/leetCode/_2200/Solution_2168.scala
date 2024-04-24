package leetCode._2200

import scala.collection.mutable

object Solution_2168 {
  def equalDigitFrequency(s: String): Int = {
    val st = mutable.Set.empty[String]

    s.indices.foreach(i => {
      val freqMap = mutable.Map.empty[Char, Int].withDefaultValue(0)
      (i until s.length).foreach(j => {
        freqMap(s(j)) += 1
        if (freqMap.values.toSet.size == 1) st.add(s.substring(i, j + 1))
      })
    })
    st.size
  }
}
