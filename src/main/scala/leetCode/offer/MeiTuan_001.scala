package leetCode.offer

import java.util.Scanner

object MeiTuan_001 {
  def isValid(userName: String): Boolean =
    userName.matches("[a-zA-Z]+\\d+[a-zA-Z0-9]*")

  def main(args: Array[String]): Unit = {
    val sc = new Scanner(System.in)
    var cnt = sc.nextInt()
    sc.nextLine()
    while (cnt != 0) {
      println(if (isValid(sc.nextLine())) "Accept" else "Wrong")
      cnt -= 1
    }
  }
}
