package leetCode

import scala.collection.mutable

object Solution_682 {
  def calPoints(ops: Array[String]): Int = {
    val st = new mutable.Stack[Int]
    ops.foreach {
      case "+" =>
        val top1 = st.pop()
        val top2 = st.pop()
        st.push(top2).push(top1).push(top2 + top1)
      case "C" => st.pop()
      case "D" => st.push(st.top * 2)
      case op => st.push(op.toInt)
    }
    st.sum
  }
}
