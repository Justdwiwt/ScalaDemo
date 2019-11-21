package leetCode

import scala.collection.mutable

object Solution_71 {
  def simplifyPath(path: String): String = {
    val p = path.split("/")
    val st = mutable.Stack[String]()
    p.foreach(i => if (i != "." && i != "") if (i == "..") {
      if (st.nonEmpty) st.pop()
    } else st.push(i))
    "/" + st.reverse.mkString("/")
  }
}
