/*
MARTIN ALEJANDRO REYES GAONA - S19120156
PROGRAMACION LOGICA Y FUNCIONAL
 */

var puntajeTotal=0
var turnos=0
var fin=false

fun main(){//metodo principal que ejecuta los casos de prueba
    var listaTiradas1 = listOf(1, 4, 4, 5, 6, 4, 5, 5, 10, 0, 1, 7, 3, 6, 4, 10, 2, 8, 6)
    var listaTiradas2 = listOf(10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10)
    var listaTiradas3 = listOf(3, 5, 0, 0, 1, 9, 8, 2, 10, 1, 5, 9, 0, 6, 2, 3, 7, 2, 3)


    print("Tu puntaje total fue de: ${calcularPuntuacion(listaTiradas1)}\n") //imprime el valor de cada juego
    reset()//resetea las variables para volver a calcular otro juego

    print("Tu puntaje total fue de: ${calcularPuntuacion(listaTiradas2)}\n")
    reset()


    print("Tu puntaje total fue de: ${calcularPuntuacion(listaTiradas3)}\n")
    reset()


}

fun calcularPuntuacion(lista: List<Int>): Int { //Calcula el puntaje final del jugador
    var j=0
    for ((i,value) in lista.withIndex()) {
        if (lista[i] == 10) { //si es un strike
            strike(i,lista)
            j++
        } else if ((j > 0 && j % 2 == 1)) {//si es un spare o open
            dosCasos(i,lista) //verifica cual de los dos es
        }
        j++
        if (fin){
            return puntajeTotal
        }
    }
    return puntajeTotal
}

fun dosCasos(pos:Int,lista: List<Int>) { //verifica si el resultado que salió es un spare o un open
    if ((lista[pos] + lista[pos - 1]) == 10 && (lista[pos] != 0)) { //solo si la suma es igual a 10
        spare(pos,lista)
    } else {
        if (lista[pos] != 0) { //si la suma es menor a 10
            open(pos,lista)
        }
    }
}

fun open(pos:Int,lista: List<Int>){ //se suma la posion acutal mas la posterior que equivale a un turno
    puntajeTotal += lista[pos] + lista[pos - 1]
    turnos+=1
}



fun spare(pos:Int,lista: List<Int>){//se suma la posion posterior a la actual mas 10 puntos
    turnos+=1
    if(turnos==10){
        puntajeTotal += lista[pos + 1] + 10
        fin=true
    }else{
        puntajeTotal += lista[pos + 1] + 10
    }
}

fun strike(pos:Int,lista: List<Int>){ //se suma las 2 posion posterior a la actual mas 10 puntos
    turnos+=1
    if(turnos==10){
        puntajeTotal += lista[pos + 1] + lista[pos + 2]+10
        fin=true
    }else{
        puntajeTotal += lista[pos + 1] + lista[pos + 2]+10
    }


}
fun reset(){ //resetera las variables para ser usadas de nuevo
    puntajeTotal=0
    turnos=0
    fin=false
}