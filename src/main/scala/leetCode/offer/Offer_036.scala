package leetCode.offer

object Offer_036 {
  def evalRPN(tokens: Array[String]): Int = tokens./:(List.empty[Int])({ case (s, token) =>
    token match {
      case "+" => s(1) + s.head :: s.drop(2)
      case "-" => s(1) - s.head :: s.drop(2)
      case "/" => s(1) / s.head :: s.drop(2)
      case "*" => s(1) * s.head :: s.drop(2)
      case _ => token.toInt :: s
    }
  }).head
}
