package net.thenobody.josephus.solver

import org.scalatest.{FlatSpec, Matchers}

/**
  * Created by antonvanco on 29/10/2016.
  */
class IterativeJosephusProblemSolverTest extends FlatSpec with Matchers {

  behavior of classOf[IterativeJosephusProblemSolver].getSimpleName

  it should "solve the problem with small input values" in {
    val testCases = Map(
      (1, 1) -> 1,
      (2, 2) -> 1,
      (3, 3) -> 2,
      (5, 3) -> 4,
      (10, 3) -> 4,
      (20, 4) -> 17
    )

    val instance = new IterativeJosephusProblemSolver

    testCases.foreach {
      case ((count, step), expResult) =>
        val result = instance.solve(count, step)

        result shouldEqual expResult
    }
  }

  it should "solve the problem with large input values" in {
    val testCases = Map(
      (1000, 1000) -> 609,
      (2000, 1000) -> 328,
      (3000, 2000) -> 389,
      (5000, 3000) -> 958,
      (10000, 3000) -> 1369,
      (20000, 4000) -> 16253
    )

    val instance = new IterativeJosephusProblemSolver

    testCases.foreach {
      case ((count, step), expResult) =>
        val result = instance.solve(count, step)

        result shouldEqual expResult
    }
  }

  it should "solve the problem with count == step" in {
    val count = 100
    val step = count

    val expResult = 22

    val instance = new IterativeJosephusProblemSolver
    val result = instance.solve(count, step)

    result shouldEqual expResult
  }

  it should "solve the problem with a large count and small step" in {
    val count = 100000
    val step = 3

    val expResult = 92620

    val instance = new IterativeJosephusProblemSolver
    val result = instance.solve(count, step)

    result shouldEqual expResult
  }

  it should "solve the problem with step larger than count" in {
    val count = 10
    val step = 30

    val expResult = 6

    val instance = new IterativeJosephusProblemSolver
    val result = instance.solve(count, step)

    result shouldEqual expResult
  }

  it should "fail when input arguments are non-positive integers" in {
    val testCases = Seq(
      (-10, 1),
      (10, -1),
      (-10, -1),
      (0, 1),
      (1, 0),
      (0, 0)
    )

    val instance = new IterativeJosephusProblemSolver

    testCases.foreach {
      case (count, step) => an [IllegalArgumentException] shouldBe thrownBy {
        instance.solve(count, step)
      }
    }
  }
}