package leetCode

object Solution_558 {

  class Node(var _value: Boolean, var _isLeaf: Boolean) {
    var value: Boolean = _value
    var isLeaf: Boolean = _isLeaf
    var topLeft: Node = _
    var topRight: Node = _
    var bottomLeft: Node = _
    var bottomRight: Node = _
  }

  def intersect(quadTree1: Node, quadTree2: Node): Node = {
    if (quadTree1.isLeaf && quadTree1.value) quadTree1
    else if (quadTree2.isLeaf && quadTree2.value) quadTree2
    else if (quadTree1.isLeaf && !quadTree1.value) quadTree2
    else if (quadTree2.isLeaf && !quadTree2.value) quadTree1
    else {
      quadTree1.topLeft = intersect(quadTree1.topLeft, quadTree2.topLeft)
      quadTree1.topRight = intersect(quadTree1.topRight, quadTree2.topRight)
      quadTree1.bottomLeft = intersect(quadTree1.bottomLeft, quadTree2.bottomLeft)
      quadTree1.bottomRight = intersect(quadTree1.bottomRight, quadTree2.bottomRight)
      if (quadTree1.topLeft.isLeaf && quadTree1.bottomRight.isLeaf
        && quadTree1.topRight.isLeaf && quadTree1.bottomRight.isLeaf
        && quadTree1.bottomRight.value == quadTree1.bottomLeft.value
        && quadTree1.topLeft.value == quadTree1.bottomLeft.value
        && quadTree1.topRight.value == quadTree1.bottomLeft.value) {
        quadTree1.value = quadTree1.topLeft.value
        quadTree1.isLeaf = true
      }
      quadTree1
    }
  }
}
