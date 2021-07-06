package br.com.zup

import org.slf4j.LoggerFactory
import java.io.FileInputStream
import java.io.FileOutputStream

fun main() {
    val request = FuncionarioRequest.newBuilder()
        .setNome("Vinicius")
        .setCpf("000000000-00")
        .setCargo(Cargo.DEV)
        .setAtivo(true)
        .setIdade(25)
        .addEndereco(FuncionarioRequest.Endereco.newBuilder()
            .setLogradouro("Rua que eu moro")
            .setCep("55555-555")
            .setComplemento("Pertinho do fim do mundo")
            .build())
        .build()
    println(request)

    request.writeTo(FileOutputStream("funcionario-request.bin"))

    val requestDeArquivoLocal = FuncionarioRequest.newBuilder()
        .mergeFrom(FileInputStream("funcionario-request.bin"))
        .setNome("Outro vinicius")
        .build()
    println(requestDeArquivoLocal)
}