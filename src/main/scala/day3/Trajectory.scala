package day3

object Trajectory {
  case class Increment(rowIncrement: Int, columnIncrement: Int)
  def countTreesOnRoute(map: String, increment: Seq[Increment]) = {
    increment.map(i =>
      countTreesOnRow(map.linesIterator.drop(i.rowIncrement).toSeq, i, i.columnIncrement)
    ).product
  }

  def countTreesOnRow(rows: Seq[String], increment: Increment, position: Int): Double = {
    val updatedPosition =
      if (rows.head.length <= position) position - rows.head.length
      else position

    val isTree = (row: String) => {
      if (row.charAt(updatedPosition) == '#') 1 else 0
    }

    rows match {
      case x :: Nil => isTree(x)
      case x :: xs =>
        isTree(x) + countTreesOnRow(
          xs.drop(increment.rowIncrement - 1),
          increment,
          updatedPosition + increment.columnIncrement
        )
    }
  }
}
