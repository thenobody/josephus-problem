# Josephus Problem Solver

Implementation of a solver for the [Josephus problem](https://en.wikipedia.org/wiki/Josephus_problem).

The project includes two versions of the implementation:

1.  **recursive** - see [RecursiveJosephusProblemSolver](https://github.com/thenobody/josephus-problem/blob/master/src/main/scala/net/thenobody/josephus/solver/RecursiveJosephusProblemSolver.scala)
1.  **iterative** - see [IterativeJosephusProblemSolver](https://github.com/thenobody/josephus-problem/blob/master/src/main/scala/net/thenobody/josephus/solver/IterativeJosephusProblemSolver.scala)

The runtime implementation can be selected by an optional argument `--mode` which can be either `recursive` or `iterative` (default is `recursive`).
See [Running](#running) for details.

## Testing
To run the unit tests of the project simply execute:

    $ sbt clean test

## Running

### Basic usage:
    $ sbt 'run n k'

where `n` and `k` are the total number of "participants" and the exclusion increment, respectively.
Example usage:

    $ sbt 'run 10 4'

which produces the result:
```
[info] Running net.thenobody.josephus.Main 10 4
22:15:23.260 [run-main-0] INFO  net.thenobody.josephus.Main$ - Using recursive mode
22:15:23.265 [run-main-0] INFO  net.thenobody.josephus.Main$ - Result: 5
```

For a more verbose list of available settings run:

    $ sbt 'run --help'

### Specifying implementation
It is possible to explicitly set the runtime implementation of the solver by setting the `--mode` parameter. Available implementations are: `recursive` or `iterative` (default is `recursive`).

Example usage:
    
    $ sbt 'run --mode iterative 100 13'
    
which produces the result:
```
[info] Running net.thenobody.josephus.Main --mode iterative 100 13
22:21:39.264 [run-main-0] INFO  net.thenobody.josephus.Main$ - Using iterative mode
22:21:39.273 [run-main-0] INFO  net.thenobody.josephus.Main$ - Result: 70
```
