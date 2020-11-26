package leetCode

object Solution_1598 {
  def minOperations(logs: Array[String]): Int = {
    logs./:(0) { case (context, op) => f(op)(context) }
  }

  def f(op: String): Int => Int = op match {
    case "./" => context => context
    case "../" => {
      case 0 => 0
      case context => context - 1
    }
    case _ => context => context + 1
  }
}
