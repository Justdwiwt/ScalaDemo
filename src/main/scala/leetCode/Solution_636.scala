package leetCode

object Solution_636 {
  def exclusiveTime(n: Int, logs: List[String]): Array[Int] = {
    var st = List.empty[Array[Int]]
    val res = Array.fill(n)(0)
    logs.foreach(log => {
      val split = log.split(":")
      val id = split.head.toInt
      val time = split(2).toInt
      if ("start".equals(split(1))) st ::= Array(id, time)
      else {
        val pop = st.last
        st = st.reverse.tail.reverse
        var interval = time - pop(1) + 1
        res(pop.head) += interval
        if (st.nonEmpty) res(st.head.head) -= interval
      }
    })
    res
  }
}
