package leetCode._1100

object Solution_1096 {
  def braceExpansionII(expression: String): List[String] = {
    @scala.annotation.tailrec
    def toPip(idx: Int, openBraceCnt: Int, subExpression: String, returnValue: List[String]): List[String] =
      if (idx >= expression.length)
        if (subExpression != "") returnValue :+ subExpression
        else returnValue
      else expression(idx) match {
        case '{' => toPip(idx + 1, openBraceCnt + 1, subExpression + '{', returnValue)
        case '}' if openBraceCnt == 1 => toPip(idx + 1, openBraceCnt - 1, "", returnValue :+ subExpression.drop(1))
        case '}' => toPip(idx + 1, openBraceCnt - 1, subExpression + '}', returnValue)
        case c if openBraceCnt == 0 => toPip(idx + 1, openBraceCnt, "", returnValue :+ c.toString)
        case c => toPip(idx + 1, openBraceCnt, subExpression + c, returnValue)
      }

    @scala.annotation.tailrec
    def cal(expression: String, idx: Int, openBraceCnt: Int, subExpression: String, returnValue: List[String]): List[String] =
      if (idx >= expression.length)
        if (subExpression == "") returnValue
        else if (subExpression.contains('{')) returnValue ++ braceExpansionII(subExpression)
        else returnValue :+ subExpression
      else expression(idx) match {
        case ',' if openBraceCnt == 0 =>
          val updatedReturnValue: List[String] = returnValue ++ {
            if (subExpression.contains('{')) braceExpansionII(subExpression)
            else List(subExpression)
          }
          cal(expression, idx + 1, 0, "", updatedReturnValue)
        case c =>
          val updatedOpenBraceCount = openBraceCnt + {
            if (c == '{') 1
            else if (c == '}') -1
            else 0
          }
          cal(expression, idx + 1, updatedOpenBraceCount, subExpression + c, returnValue)
      }

    def fromPip(pipelineSteps: List[Set[String]]): Set[String] = pipelineSteps.headOption match {
      case Some(cur: Set[String]) => cur.flatMap(c => fromPip(pipelineSteps.tail).map(rest => c + rest))
      case None => Set("")
    }

    val pip: List[Set[String]] = toPip(0, 0, "", List.empty)
      .map((exp: String) => cal(exp, 0, 0, "", List.empty).toSet)

    fromPip(pip).toList.sorted
  }
}
