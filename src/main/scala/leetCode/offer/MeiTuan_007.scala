package leetCode.offer

import java.io.{BufferedReader, InputStreamReader}
import scala.collection.mutable
import scala.util.control.Breaks._

object MeiTuan_007 {
  def main(args: Array[String]): Unit = {
    val reader = new BufferedReader(new InputStreamReader(System.in))
    val num = reader.readLine().toInt
    val st = mutable.HashSet.empty[String]
    (0 until num).foreach(_ => {
      val t = reader.readLine().split(" ")
      breakable {
        (0 until num).foreach(j => {
          val p = t(j)
          if (st.add(p)) {
            println(p + " ")
            break()
          }
        })
      }
    })
  }
}
