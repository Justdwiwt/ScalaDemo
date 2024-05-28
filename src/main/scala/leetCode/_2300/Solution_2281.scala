package leetCode._2300

import scala.collection.mutable.ListBuffer

object Solution_2281 {
  def totalStrength(strength: Array[Int]): Int = {
    val M = 1000000007
    val n = strength.length

    val left = Array.fill(n)(-1)
    val right = Array.fill(n)(n)

    val st = ListBuffer.empty[Int]
    st.append(-1)

    strength.indices
      .foreach(i => {
        while (st.size > 1 && strength(st.last) >= strength(i))
          right(st.remove(st.size - 1)) = i
        left(i) = st.last
        st.append(i)
      })

    var s = 0L

    val ss = Array.fill(n + 2)(0L)
    (1 to n)
      .foreach(i => {
        s += strength(i - 1)
        ss(i + 1) = (ss(i) + s) % M
      })

    var res = 0L

    strength.indices.foreach(i => {
      val l = left(i) + 1
      val r = right(i) - 1
      val tot = ((i - l + 1).toLong * (ss(r + 2) - ss(i + 1)) - (r - i + 1).toLong * (ss(i + 1) - ss(l))) % M
      res = (res + strength(i) * tot) % M
    })
    ((res + M) % M).toInt
  }
}
