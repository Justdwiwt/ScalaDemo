package leetCode._800

object Solution_736 {
  def evaluate(expression: String): Int =
    Expression(expression).evaluate()
}

trait Expression {
  def evaluate(context: Map[Expression, Expression] = Map()): Int
}

sealed case class Const(num: Int) extends Expression {
  override def evaluate(context: Map[Expression, Expression] = Map()): Int = num
}

sealed case class Vari(name: String) extends Expression {
  override def evaluate(context: Map[Expression, Expression] = Map()): Int = context(Vari(name)).evaluate()
}

sealed case class Mul(left: Expression, right: Expression) extends Expression {
  override def evaluate(context: Map[Expression, Expression] = Map()): Int = left.evaluate(context) * right.evaluate(context)
}

sealed case class Add(left: Expression, right: Expression) extends Expression {
  override def evaluate(context: Map[Expression, Expression] = Map()): Int = left.evaluate(context) + right.evaluate(context)
}

sealed case class Let(context: List[(Expression, Expression)], expr: Expression) extends Expression {
  override def evaluate(contextNew: Map[Expression, Expression] = Map()): Int = {
    @scala.annotation.tailrec
    def loop(con: List[(Expression, Expression)], acc: Map[Expression, Expression] = Map()): Map[Expression, Expression] = con match {
      case a :: tail => loop(tail, acc + (a._1 -> Const(a._2.evaluate(contextNew ++ acc))))
      case Nil => acc
    }

    expr.evaluate(contextNew ++ loop(context))
  }
}

object Expression {
  def apply(expression: String): Expression = expression match {
    case _ if expression.startsWith("(let") => Let(expression)
    case _ if expression.startsWith("(mul") => Mul(expression)
    case _ if expression.startsWith("(add") => Add(expression)
    case _ => scala.util.Try(Const.apply(expression).asInstanceOf[Expression]).orElse(scala.util.Try(Vari.apply(expression))).get
  }

  @scala.annotation.tailrec
  def parse(chars: String, index: Int = 0, valu: String, acc: List[Expression]): List[Expression] = {
    if (index == chars.length) return (if (valu.trim.isEmpty) acc else Expression.apply(valu) :: acc).reverse
    chars(index) match {
      case '(' =>
        val endIndex = Util.getMatching(chars, index) + 1
        parse(chars, endIndex, "", Expression.apply(chars.substring(index, endIndex)) :: acc)
      case ' ' =>
        parse(chars, index + 1, "", if (valu.trim.nonEmpty) Expression.apply(valu) :: acc else acc)
      case a => parse(chars, index + 1, valu + a, acc)
    }
  }
}

object Const {
  def apply(expr: String): Const =
    Const(expr.toInt)
}

object Add {
  def apply(expression: String): Expression = {
    val str = expression.substring(expression.indexOf('(') + 1, expression.lastIndexOf(')')).trim
    val strCont = str.replaceFirst("add", "").trim
    val comp = Expression.parse(strCont, 0, "", Nil)
    Add(comp.head, comp(1))
  }
}

object Mul {
  def apply(expression: String): Expression = {
    val str = expression.substring(expression.indexOf('(') + 1, expression.lastIndexOf(')')).trim
    val strCont = str.replaceFirst("mult", "").trim
    val comp = Expression.parse(strCont, 0, "", Nil)
    Mul(comp.head, comp(1))
  }
}

object Let {
  def apply(expression: String): Expression = {
    val str = expression.substring(expression.indexOf('(') + 1, expression.lastIndexOf(')')).trim
    val strCont = str.replaceFirst("let", "").trim
    val comp = Expression.parse(strCont, 0, "", Nil)
    val cont = (0 until comp.length / 2).map(ind => comp(ind * 2) -> comp(ind * 2 + 1)).toList
    var map = Map[Expression, Expression]()
    cont.foreach(each => map = map + (each._1 -> each._2))
    Let(cont, comp.last)
  }
}

object Util {
  def getMatching(expression: String, index: Int): Int = {
    val parenthesis = Array.fill(expression.length)(-1)
    var count = 0
    expression.indices.foreach(index => expression.charAt(index) match {
      case '(' => count = count + 1; parenthesis(index) = count
      case ')' => parenthesis(index) = count; count = count - 1
      case _ =>
    })

    val some = parenthesis
      .zipWithIndex
      .find(_._2 == index)
      .map(indexNode => parenthesis.zipWithIndex.filter(a => a._1 == indexNode._1 && a._2 >= index).map(_._2))

    some match {
      case Some(nums) => nums.sorted.apply(1)
      case None => -1
    }
  }
}
