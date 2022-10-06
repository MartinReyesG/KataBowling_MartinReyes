var puntajeTotal=0
var turnos=0
var fin=false
fun main(){
    var listaTiradas1 = listOf(1, 4, 4, 5, 6, 4, 5, 5, 10, 0, 1, 7, 3, 6, 4, 10, 2, 8, 6)
    var listaTiradas2 = listOf(10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10)
    var listaTiradas3 = listOf(3, 5, 0, 0, 1, 9, 8, 2, 10, 1, 5, 9, 0, 6, 2, 3, 7, 2, 3)


    print("Tu puntaje total fue de: ${calcularPuntuacion(listaTiradas1)}\n")
    reset()

    print("Tu puntaje total fue de: ${calcularPuntuacion(listaTiradas2)}\n")
    reset()


    print("Tu puntaje total fue de: ${calcularPuntuacion(listaTiradas3)}\n")
    reset()


}

fun calcularPuntuacion(lista: List<Int>): Int {
    var j=0
    for ((i,value) in lista.withIndex()) {
        if (lista[i] == 10) {
            strike(i,lista)
            j++
        } else if ((j > 0 && j % 2 == 1)) {
            dosCasos(i,lista)
        }
        j++
        if (fin){
            return puntajeTotal
        }
    }
    return puntajeTotal
}

fun dosCasos(pos:Int,lista: List<Int>) {
    if ((lista[pos] + lista[pos - 1]) == 10 && (lista[pos] != 0)) {
        spare(pos,lista)
    } else {
        if (lista[pos] != 0) {
            open(pos,lista)
        }
    }
}

fun open(pos:Int,lista: List<Int>){
    puntajeTotal += lista[pos] + lista[pos - 1]
    turnos+=1
}



fun spare(pos:Int,lista: List<Int>){
    turnos+=1
    if(turnos==10){
        puntajeTotal += lista[pos + 1] + 10
        fin=true
    }else{
        puntajeTotal += lista[pos + 1] + 10
    }
}

fun strike(pos:Int,lista: List<Int>){
    turnos+=1
    if(turnos==10){
        puntajeTotal += lista[pos + 1] + lista[pos + 2]+10
        fin=true
    }else{
        puntajeTotal += lista[pos + 1] + lista[pos + 2]+10
    }


}
fun reset(){
    puntajeTotal=0
    turnos=0
    fin=false
}