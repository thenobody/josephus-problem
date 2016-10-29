package net.thenobody.josephus

/**
  * Created by antonvanco on 29/10/2016.
  */
class LinearJosephusProblemSolver extends JosephusProblemSolver {
  def solve(count: Int, step: Int): Int = (count, step) match {
    case (ValidValue(c), ValidValue(s)) =>
      (1 to c).foldLeft(0) {
        case (result, i) if i == 1 => 1
        case (result, i) => (result + step - 1) % i + 1
      }
    case _ =>
      throw new IllegalArgumentException(s"Arguments need to be positive integers, given count: $count, step: $step")
  }
}