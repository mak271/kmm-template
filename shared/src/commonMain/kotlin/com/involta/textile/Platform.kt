package com.involta.textile

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform

/*
@Composable
fun Hello(){

}*/
