package leetCode

object Solution_224 {
  def calculate(s: String): Int = {
    @scala.annotation.tailrec
    def tokenize(s: String, cur: List[String]): List[String] =
      if (s.isEmpty) cur.reverse
      else s.head match {
        case ' ' => tokenize(s.drop(1), cur)
        case '+' | '(' | ')' => tokenize(s.drop(1), s.head.toString :: cur)
        case '-' => cur match {
          case Nil | ("+" | "(") :: _ => tokenize(s.drop(1), s.head.toString :: "0" :: cur)
          case _ => tokenize(s.drop(1), s.head.toString :: cur)
        }
        case _ =>
          val (number, rest) = s.span(!"+-() ".contains(_))
          tokenize(rest, number :: cur)
      }

    @scala.annotation.tailrec
    def eval(nums: List[Int], ops: List[String], expr: List[String]): Int = expr match {
      case Nil => nums.head
      case "(" :: es => eval(nums, "(" :: ops, es)
      case "+" :: es => eval(nums, "+" :: ops, es)
      case "-" :: es => eval(nums, "-" :: ops, es)
      case ")" :: es => ops match {
        case "(" :: os => eval(nums.tail, os, nums.head.toString :: es)
        case _ => 0
      }
      case v :: es => ops match {
        case "+" :: os => eval((nums.head + v.toInt) :: nums.tail, os, es)
        case "-" :: os => eval((nums.head - v.toInt) :: nums.tail, os, es)
        case _ => eval(v.toInt :: nums, ops, es)
      }
    }

    eval(Nil, Nil, tokenize(s, Nil))
  }
}
