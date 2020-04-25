package leetCode

object LCP_08 {
  def getTriggerTime(increase: Array[Array[Int]], requirements: Array[Array[Int]]): Array[Int] = {
    val s = Array.fill(increase.length + 1)(Array.fill(3)(0))
    increase.indices.foreach(i => (0 until 3).foreach(j => s(i + 1)(j) = s(i)(j) + increase(i)(j)))
    var res = Array.empty[Int]
    requirements.foreach(v => {
      var l = 0
      var r = increase.length
      while (l < r) {
        val m = (l + r) / 2
        if (s(m)(0) >= v(0) && s(m)(1) >= v(1) && s(m)(2) >= v(2)) r = m
        else l = m + 1
      }
      if (s(l)(0) >= v(0) && s(l)(1) >= v(1) && s(l)(2) >= v(2)) res :+= l
      else res :+= -1
    })
    res
  }
}
