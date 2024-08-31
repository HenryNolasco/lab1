package lab1.modules

class PrimeNumberProcessor(N: Int) {
    private var primos = ArrayList<EvaluationResult>()
    private var pares = ArrayList<EvaluationResult>()
    private var impares = ArrayList<EvaluationResult>()

    init {
        if (N <= 0) {
            throw IllegalArgumentException("primer numero de rango no puede ser negativo o 0")
        }
        processRange(1..N)
    }

    private fun processRange(rango: IntRange) {
        for (numero in rango){
            if (numero == 0) {
                pares. add(EvaluationResult(numero, arrayListOf<Int>(), NumberType.EVEN))
            } else if (numero == 1){
                impares.add(EvaluationResult(1, arrayListOf<Int>(), NumberType.ODD))
            } else {
                validateNumber(numero)
            }
        }
        println("Prime numbers: " + primos.size)
        println("Even numbers: " + pares.size)
        println("Odd numbers:" + impares.size)
        println()
    }

    private fun validateNumber(numero: Int) {
        val divisores = findFactors(numero)

        if (divisores.size <= 2) {
            primos.add(EvaluationResult(numero, divisores, NumberType.PRIME))
        } else if (numero % 2 == 0){
            pares.add(EvaluationResult(numero, divisores, NumberType.EVEN))
        } else{
            impares.add(EvaluationResult(numero,divisores, NumberType.ODD))
        }
    }

    private fun findFactors(numero: Int):ArrayList<Int> {
        val factores = ArrayList<Int>()

        for (i in 1..numero) {
            if (numero % i == 0){
                factores.add(i)
            }
        }
        return factores
    }
}
