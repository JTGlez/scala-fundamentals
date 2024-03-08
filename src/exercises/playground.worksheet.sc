def isPrimeTailRecursive(n: Int): Boolean = {
    @scala.annotation.tailrec
    def isPrimeUntilAux(t: Int, accumulator: Boolean): Boolean = {
        if (t <= 1) accumulator
        else isPrimeUntilAux(t - 1, accumulator && (n % t != 0))
    }
    isPrimeUntilAux(n / 2, true)
}
