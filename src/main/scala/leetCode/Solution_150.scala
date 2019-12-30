package leetCode

import scala.collection.mutable

object Solution_150 {
  def evalRPN(tokens: Array[String]): Int = {
    val stack = new mutable.Stack[Int]
    tokens.foreach {
      case "+" => stack.push(stack.pop() + stack.pop())
      case "-" => stack.push(-stack.pop() + stack.pop())
      case "*" => stack.push(stack.pop() * stack.pop())
      case "/" =>
        val top = stack.pop()
        stack.push(stack.pop() / top)
      case n => stack.push(n.toInt)
    }
    stack.pop()
  }
}
