package leetCode

object Solution_636 {
  trait Entry

  case class StartEntry(func: Int, time: Int) extends Entry

  case class EndEntry(func: Int, time: Int) extends Entry

  def exclusiveTime(n: Int, logs: List[String]): Array[Int] = {
    val functionTimes = logs.map(_.split(":")).map({
      case Array(f, "start", t) => StartEntry(f.toInt, t.toInt)
      case Array(f, _, t) => EndEntry(f.toInt, t.toInt)
    })
    val res = Array.fill(n)(0)
    f(functionTimes, Nil, res, 0)
    res
  }

  @scala.annotation.tailrec
  def f(list: List[Entry], st: List[Entry], res: Array[Int], prev: Int): Unit = list match {
    case Nil => ()
    case StartEntry(headFunction, headTime) :: tail if st.isEmpty =>
      f(tail, StartEntry(headFunction, headTime) :: st, res, headTime)
    case StartEntry(headFunction, headTime) :: tail =>
      val StartEntry(stackFunction, _) = st.head
      res(stackFunction) = res(stackFunction) + headTime - prev
      f(tail, StartEntry(headFunction, headTime) :: st, res, headTime)
    case EndEntry(_, headTime) :: tail =>
      val StartEntry(stackFunction, _) = st.head
      res(stackFunction) = res(stackFunction) + headTime - prev + 1
      f(tail, st.tail, res, headTime + 1)
  }
}
