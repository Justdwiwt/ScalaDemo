package leetCode

import java.io.{BufferedReader, InputStreamReader}
import scala.util.control.Breaks._

object MeiTuan_006 {
  def main(args: Array[String]): Unit = {
    val br = new BufferedReader(new InputStreamReader(System.in))
    val s = br.readLine()
    var f1 = false
    var f2 = false
    var a, b = 0
    breakable {
      s.indices.foreach(i => {
        if (s(i) == 'M') f1 = true
        if (f1 && s(i) == 'T') {
          a = i
          break()
        }
      })
    }
    breakable {
      s.indices.reverse.foreach(i => {
        if (s(i) == 'T') f2 = false
        if (f2 && s(i) == 'M') {
          b = i
          break()
        }
      })
    }
    println(s.substring(a + 1, b))
  }
}
