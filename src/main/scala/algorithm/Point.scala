package algorithm

object Point {

  def random(): Point = {
    new Point(math.random * 50, math.random * 50)
  }

}

case class Point(x: Double, y: Double) {

  def +(that: Point) = new Point(this.x + that.x, this.y + that.y)

  def -(that: Point) = new Point(this.x - that.x, this.y - that.y)

  def /(d: Double) = new Point(this.x / d, this.y / d)

  def pointLength: Double = math.sqrt(x * x + y * y)

  def distance(that: Point): Double = (this - that).pointLength

  def format(str: String, x: Double, y: Double): String = ""

  override def toString: String = format("(%.3f, %.3f)", x, y)

}
