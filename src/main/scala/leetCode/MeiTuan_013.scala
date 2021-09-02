package leetCode

import java.util.Scanner

object MeiTuan_013 {
  def main(args: Array[String]): Unit = {
    val sc = new Scanner(System.in)
    val n = sc.nextLine().toInt
    val s = sc.nextLine()
    var res = 0
    var cnt = 0
    (0 until n).foreach(i => {
      if (s(i) == 'E') {
        cnt += 1
        res = res.max(cnt)
      } else if (cnt > 0) cnt -= 1
    })
    sc.close()
    println(res)
  }
}
