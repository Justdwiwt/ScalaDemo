package leetCode

import scala.collection.mutable

object Solution_736 {
  def evaluate(expression: String): Int = {
    val letPattern = "\\(let (.+)\\)".r
    val addPattern = "\\(add (.+)\\)".r
    val multPattern = "\\(mult (.+)\\)".r
    val numberPattern = "([+|-]?\\d+)".r
    val variablePattern = "(\\w[\\w|\\d]*)".r

    def eval(expression: String, globalVariables: Map[String, Int]): Int = {
      val localVariables = mutable.HashMap.empty[String, Int]

      expression match {
        case letPattern(str) =>
          val (vars, expr) = parseVariables(str)
          vars.foreach({ case (x, expr) =>
            localVariables += x -> eval(expr, globalVariables ++ localVariables.toMap)
          })
          eval(expr, globalVariables ++ localVariables.toMap)
        case addPattern(str) =>
          val (leftExpr, rightExpr) = parseOperands(str)
          operator(_ + _)(leftExpr, rightExpr, globalVariables)
        case multPattern(str) =>
          val (leftExpr, rightExpr) = parseOperands(str)
          operator(_ * _)(leftExpr, rightExpr, globalVariables)
        case numberPattern(str) =>
          str.toInt
        case variablePattern(str) if globalVariables.contains(str) =>
          globalVariables(str)
        case str => throw new IllegalArgumentException(s"Can`t parse $str")
      }
    }

    @scala.annotation.tailrec
    def parseVariables(str: String, res: (Array[(String, String)], String) = (Array.empty[(String, String)], "")): (Array[(String, String)], String) = {
      if (str == "") res
      else {
        val (first, i) = parseExpression(str)
        if (i == str.length) (res._1, res._2 + first)
        else {
          val (second, j) = parseExpression(str.drop(i + 1))
          parseVariables(str.drop(i + 1 + j + 1), (res._1 :+ (first, second), res._2))
        }
      }
    }

    def parseOperands(str: String): (String, String) = {
      val (left, i) = parseExpression(str)
      (left, str.drop(i + 1))
    }

    def parseExpression(str: String): (String, Int) = {
      var i = 0
      var brackets = 0
      if (str.head == '(') {
        brackets += 1
        i = 1
        while (i < str.length && brackets != 0) {
          if (str(i) == '(') brackets += 1
          if (str(i) == ')') brackets -= 1
          i += 1
        }
      } else {
        i = 0
        while (i < str.length && str(i) != ' ') i += 1
      }
      (str.take(i), i)
    }

    def operator(f: (Int, Int) => Int)(leftExpression: String, rightExpression: String, variables: Map[String, Int]): Int =
      f(eval(leftExpression, variables), eval(rightExpression, variables))

    eval(expression, Map.empty[String, Int])
  }
}
