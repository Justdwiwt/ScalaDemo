package leetCode._1900

import scala.collection.mutable

object Solution_1896 {
  def minOperationsToFlip(expression: String): Int = {
    val revExpr = expression.reverse

    sealed trait ParseOp
    case class NodeInfo(minOps: Int, value: Int)
    case class ExploreOp(start: Int, end: Int) extends ParseOp
    case class VisitOperandOp(position: Int) extends ParseOp
    case class VisitValueOp(position: Int) extends ParseOp

    val ops = mutable.Stack[ParseOp](ExploreOp(0, revExpr.length))
    val evals = mutable.Stack[NodeInfo]()

    while (ops.nonEmpty) {
      ops.pop() match {
        case VisitValueOp(position) =>
          val value = revExpr(position) - '0'
          evals.push(NodeInfo(1, value))

        case VisitOperandOp(position) =>
          val leftInfo = evals.pop()
          val rightInfo = evals.pop()
          val (minOps, value) = if (revExpr(position) == '|') {
            if (leftInfo.value != rightInfo.value) (1, 1)
            else if (leftInfo.value == 1) (1 + leftInfo.minOps.min(rightInfo.minOps), 1)
            else (leftInfo.minOps.min(rightInfo.minOps), 0)
          } else if (revExpr(position) == '&') {
            if (leftInfo.value != rightInfo.value) (1, 0)
            else if (leftInfo.value == 1) (leftInfo.minOps.min(rightInfo.minOps), 1)
            else (1 + leftInfo.minOps.min(rightInfo.minOps), 0)
          } else throw new IllegalArgumentException("")
          evals.push(NodeInfo(minOps, value))

        case ExploreOp(start, end) =>
          val nextOpOpt = findNextOp(revExpr, start, end)
          nextOpOpt match {
            case None =>
              if (start + 1 == end && (revExpr(start) == '0' || revExpr(start) == '1')) ops.push(VisitValueOp(start))
              else if (revExpr(start) == ')') {
                val (subStart, subEnd) = getEnclosedSubExpr(revExpr, start, end)
                ops.push(ExploreOp(subStart, subEnd))
              } else throw new IllegalArgumentException("")

            case Some(nextOp) =>
              ops.push(VisitOperandOp(nextOp))
              ops.push(ExploreOp(start, nextOp))
              ops.push(ExploreOp(nextOp + 1, end))
          }
      }
    }

    evals.pop().minOps
  }

  private def findNextOp(exprStr: String, start: Int, end: Int): Option[Int] = {
    var braceCounter = 0
    var i = start - 1
    var found = false
    while (!found && i < end - 1) {
      i += 1
      if (exprStr(i) == ')') braceCounter += 1
      else if (exprStr(i) == '(') braceCounter -= 1
      else if (braceCounter <= 0 && (exprStr(i) == '|' || exprStr(i) == '&')) found = true
    }
    if (found) Some(i) else None
  }

  private def getEnclosedSubExpr(exprStr: String, start: Int, end: Int): (Int, Int) = {
    var bracesInRow = 0
    var i = start
    var stop = false
    while (!stop && i < end) {
      if (exprStr(i) == ')') bracesInRow += 1
      else stop = true
      i += 1
    }

    var (l, r) = (start, start + bracesInRow - 1)
    while (l < r) {
      val mid = l + (r + 1 - l) / 2
      val nextOpOpt = findNextOp(exprStr, mid, end)
      nextOpOpt match {
        case Some(nextOp) => if (nextOp == end) l = mid else r = mid - 1
        case None => l = mid
      }
    }

    (l + 1, end - (l - start + 1))
  }
}
