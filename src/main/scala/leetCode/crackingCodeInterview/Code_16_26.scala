package leetCode.crackingCodeInterview

import scala.collection.mutable

object Code_16_26 {
  def calculate(s: String): Int = {
    val trimmed = s.replaceAll(" ", "")
    val q = mutable.Stack[Int]()
    var flag = '+'
    var num = 0

    (0 until trimmed.length).foreach(i => {
      if (trimmed(i).isDigit)
        num = num * 10 + (trimmed(i) - '0')

      if (!trimmed(i).isDigit || i == trimmed.length - 1) {
        flag match {
          case '+' => q.push(num)
          case '-' => q.push(-num)
          case '*' => q.push(q.pop() * num)
          case '/' => q.push(q.pop() / num)
          case _ =>
        }
        flag = trimmed(i)
        num = 0
      }
    })

    var res = 0
    while (q.nonEmpty) res += q.pop()
    res
  }
}
